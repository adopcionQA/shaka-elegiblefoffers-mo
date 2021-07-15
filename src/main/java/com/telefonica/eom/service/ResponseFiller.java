package com.telefonica.eom.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.xml.datatype.DatatypeConfigurationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.benefits.Benefits;
import com.telefonica.eom.business.financing.VerifyFinancing;
import com.telefonica.eom.business.penalty.VerifyPenalty;
import com.telefonica.eom.business.ppf.VerifyPPF;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.entity.PriceProperties;
import com.telefonica.eom.generated.offers.model.CategoryTreeType;
import com.telefonica.eom.generated.offers.model.ComponentProdOfferPriceType;
import com.telefonica.eom.generated.offers.model.ComponentProdOfferPriceType.PriceTypeEnum;
import com.telefonica.eom.generated.offers.model.KeyValueType;
import com.telefonica.eom.generated.offers.model.OfferingType;
import com.telefonica.eom.generated.offers.model.OfferingType.BillingMethodEnum;
import com.telefonica.eom.generated.offers.model.OfferingType.LifeCycleStatusEnum;
import com.telefonica.eom.generated.offers.model.OfferingType.TypeEnum;
import com.telefonica.eom.generated.offers.model.PaginationInfoType;
import com.telefonica.eom.generated.offers.model.ProductInstanceRefType;
import com.telefonica.eom.mapper.PlanBoDetailsBusinessMapper;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.proxy.penalty.Penalty;
import com.telefonica.eom.proxy.pinventory.ParqueUnificadoConnection;
import com.telefonica.eom.repository.PricePropertiesRepo;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryListType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PagingInfoOutputType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PlanBODetailsType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;

import pe.telefonica.customerordermanagement.orderservices.v1.types.DevicePenaltyInfo;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: ResponseFiller.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que obtendra genera el response del servicio
 */
@Service
public class ResponseFiller {

	@Autowired
	VerifyPPF verifyPPF;

	@Autowired
	VerifyFinancing verifyFinancing;

	@Autowired
	ResponseSubFieldsFiller rsff;

	@Autowired
	ParqueUnificadoConnection puConnection;

	@Autowired
	Benefits benefits;

	@Autowired
	PlanBoDetailsBusinessMapper planBoDetailsBusinessMapper;

	@Autowired
	Penalty penalty;

	@Autowired
	VerifyPenalty verifyPenalty;
	
	@Autowired
	PricePropertiesRepo priceRepo;


	/**
	 * Metodo que retorna una lista de OfferingType
	 * 
	 * @param List<CategoryListType> ,MobileElegibleOffersRequest
	 * @return List<OfferingType>
	 */
	public List<OfferingType> getResponse(List<CategoryListType> categories, MobileElegibleOffersRequest meor) {
		
		List<ProductInstanceRefType> compatibleProducts = new ArrayList<>();
		BusinessReference businessRef;
		String applyFinancing;
		
		applyFinancing = verifyFinancing.validate(meor);

		if (meor.getProductPublicId() != null && meor.getProductType() != null) {
			compatibleProducts = rsff.getCompatibleProducts(
					puConnection.callRestService(meor.getProductPublicId(), meor.getProductType()));
		}

		businessRef = planBoDetailsBusinessMapper.fromOfferingsAMDOCStoReference(meor, categories);
		
		categories.forEach(c -> c.getOfferings()
			.forEach(o -> o.getPlanBoList()
					.removeIf(bo -> filterOffer(bo.getBillingOfferId(), meor.getTypeRent()))));

		return categoryLevel(categories, compatibleProducts, applyFinancing, meor, businessRef, meor.getProduct());
	}
	
	/**
	 * filtra los planes segun la renta
	 * @param boId
	 * @param typeRent
	 * @return
	 */
	 private Boolean filterOffer( String boId, String typeRent) {  
	     
	     if (typeRent != null) {
		List<PriceProperties> priceLst = priceRepo.findDistinctByNamePropAbp(Constant.PAYMENT_TIMING);
	    	
	     return !typeRent.equals(priceLst.stream()
	     			.filter(pr -> pr.getBillingOfferId().equals(boId))
	     			.map(PriceProperties :: getValueAbp)
	     			.findFirst()
	     			.orElse(Constant.EMPTY));  
	    }
	     
	     return Boolean.FALSE;
	     	        			
	 }


	public PaginationInfoType getPagination(List<CategoryListType> categories, Integer page) {

		PaginationInfoType paginationInfoType = new PaginationInfoType();
		PagingInfoOutputType paginationInfo = categories.get(0).getPaginationInfo();

		if (!(Objects.isNull(paginationInfo) || paginationInfo.getTotalResultsInCategory() == null
				|| paginationInfo.getItemsPerCategory() == null)) {

			BigDecimal totalPages = paginationInfo.getTotalResultsInCategory()
					.divide(paginationInfo.getItemsPerCategory());
			BigDecimal totalResults = paginationInfo.getTotalResultsInCategory();
			Boolean last = Boolean.FALSE;

			if (Boolean.FALSE.equals(paginationInfo.isHasMore())) {
				last = Boolean.TRUE;
			}

			if (page == 1) {
				paginationInfoType.setFirst(true);
			}

			paginationInfoType.setItemsPerPage(paginationInfo.getItemsPerPage().intValue());
			paginationInfoType.setTotalPages(totalPages.intValue());
			paginationInfoType.setTotalResults(totalResults.intValue());
			paginationInfoType.last(last);

		}

		return paginationInfoType;

	}

	/**
	 * Metodo que retorna una lista de tipo OfferingType
	 * 
	 * @param List<CategoryListType>
	 * @return List<OfferingType>
	 */
	private List<OfferingType> categoryLevel(List<CategoryListType> categories, List<ProductInstanceRefType> compatibleProducts, String applyFinancing, MobileElegibleOffersRequest meor, BusinessReference businessRef, String product) {
		
		List<OfferingType> offerings = new ArrayList<>();

		categories.forEach(category -> {
			CategoryTreeType ctt = rsff.getCategory(category.getCategory());
			
			if (category.getCategory().getSubcategories() != null) {
				ctt.setSubcategories(rsff.getCategory(category.getCategory().getSubcategories()));
			}
			
			String currentPlanRelationID = category.getCurrentPlanRelationId();
			
			category.getOfferings().forEach(o -> {
			offerings.add(offeringsLevel(o, compatibleProducts, applyFinancing, meor, ctt, businessRef, currentPlanRelationID, product));
			});
		});

		return offerings;
	}

	/**
	 * Metodo que retorna un objeto OfferingType
	 * 
	 * @param OfferingTypeOfferType
	 * @return OfferingType
	 */
	private OfferingType offeringsLevel(OfferingTypeOfferType offerType, List<ProductInstanceRefType> compatibleProducts, String applyFinancing, MobileElegibleOffersRequest meor, CategoryTreeType ctt, BusinessReference businessRef, String currentPlanRelationID, String product) {

		OfferingType offering = new OfferingType();

		String billingMethod = offerType.getPlanType();
		String catalogItemCode = offerType.getCatalogItemCode();
		String catalogItemId = offerType.getCatalogItemId();

		DevicePenaltyInfo devicePenaltyInfo = this.ifCallPenalty(meor, billingMethod);

		offering.setId(offerType.getCatalogItemId());
		offering.setHref(Constant.HREF.concat(offerType.getCatalogItemId()));
		offering.setName(offerType.getName());
		offering.setCode(offerType.getCatalogItemCode());
		offering.setCatalogItemType(offerType.getCatalogItemType());
		offering.setCorrelationId(offerType.getCorrelationId());
		offering.setDescription(offerType.getDescription());
		offering.setCurrentPlanRelationID(currentPlanRelationID);
		offering.setCategory(Arrays.asList(ctt));
		offering.setBillingMethod(BillingMethodEnum.fromValue(offerType.getPlanType()));
		offering.setType(TypeEnum.fromValue(meor.getType()));
		offering.setCustomerId(meor.getCustomerId());
		offering.setCompatibleProducts(compatibleProducts);
		offering.setIsBundle(offerType.isIsBundle());
		offering.setLifeCycleStatus(LifeCycleStatusEnum.fromValue(offerType.getLifeCycleStatus()));
		offering.setAdditionalData(rsff.getAdditionalData(offerType, applyFinancing));
		offering.setProductOfferingPrice(this.getProductOfferingPriceList(offerType.getPlanBoList(), meor, businessRef, devicePenaltyInfo, billingMethod, catalogItemCode, catalogItemId, product));
		offering.setProductOfferingProductSpecID(this.getProductOfferingProductSpecID(offerType));

		return offering;
	}

	/**
	 * Metodo que retorna una lista de PlanBODetailsType
	 * 
	 * @param List<PlanBODetailsType>
	 * @return List<ComponentProdOfferPriceType>
	 */
	private List<ComponentProdOfferPriceType> getProductOfferingPriceList(List<PlanBODetailsType> planBoList,MobileElegibleOffersRequest meor, BusinessReference businessRef, DevicePenaltyInfo devicePenaltyInfo, String billingMethod, String catalogItemCode, String catalogItemId, String product) {
			
		return planBoList.stream().map(p -> getProductOfferingPrice(p, meor, businessRef, devicePenaltyInfo, billingMethod, catalogItemCode, catalogItemId, product)).collect(Collectors.toList());
	}

	/**
	 * Metodo que retorna un objeto ComponentProdOfferPriceType
	 * 
	 * @param PlanBODetailsType
	 * @return ComponentProdOfferPriceType
	 */
	private ComponentProdOfferPriceType getProductOfferingPrice(PlanBODetailsType pBOdt, MobileElegibleOffersRequest meor, BusinessReference businessRef, DevicePenaltyInfo devicePenaltyInfo, String billingMethod, String catalogItemCode, String catalogItemId, String product) {

		PriceDetailsType pdt1 = getPriceDetails(pBOdt);

		ComponentProdOfferPriceType cpopt = new ComponentProdOfferPriceType();
		cpopt.setId(pBOdt.getBillingOfferId());
		cpopt.setCode(pBOdt.getBillingOfferCode());
		cpopt.setName(pBOdt.getBillingOfferName());
		cpopt.setDescription(Constant.OFFER_PRICE_DESCRIPTION);

		if (!Constant.PREPAID.equalsIgnoreCase(product) && pdt1 != null) {
			cpopt.setPriceType(Util.enumEquivalence(pdt1.getPriceType()));
			cpopt.setPrice(rsff.getPrice(pdt1.getOriginalAmount(), pdt1.getPrice()));
			cpopt.setPriceWithTax(rsff.getPriceWithTax(pdt1.getOriginalAmount()));
			cpopt.setOriginalAmount(rsff.getOriginalAmount(pdt1.getOriginalAmount()));
			cpopt.setOriginalTaxAmount(rsff.getPriceWithTax(pdt1.getOriginalAmount()));
		}

		cpopt.setProductSpecContainmentID(pBOdt.getProductSpecContainmentID());
		cpopt.setPricePlanSpecContainmentID(pBOdt.getPricePlanSpecContainmentID());

		cpopt.setPricedComponents(this.getPricedComponents(pBOdt.getBillingOfferId(), meor, devicePenaltyInfo, billingMethod, businessRef));
		cpopt.setBenefits(benefits.benefistsList(meor, businessRef, catalogItemCode, catalogItemId, pBOdt.getBillingOfferCode()));
		cpopt.setAdditionalData(rsff.getAditionalDataPOP(pBOdt.getPlanInfo()));

		return cpopt;
	}

	/**
	 * Metodo que retorna una lista de KeyValueType
	 * 
	 * @param String
	 * @return List<KeyValueType>
	 */
	private List<KeyValueType> getPricedComponents(String poPriceId, MobileElegibleOffersRequest meor, DevicePenaltyInfo devicePenaltyInfo, String billingMethod, BusinessReference businessRef) {
		KeyValueType kvtPPF = new KeyValueType();
		kvtPPF.setKey(Constant.EASY_POST_PAYMENT);
		kvtPPF.setValue(verifyPPF.validate(meor, poPriceId, billingMethod));
		KeyValueType kvtPenalty = new KeyValueType();
		kvtPenalty.setKey(Constant.EXEMPT_PENALTY);
		kvtPenalty.setValue(verifyPenalty.validate(meor, billingMethod, devicePenaltyInfo, businessRef, poPriceId));
		
//		List<PriceProperties> priceLst = priceRepo.findDistinctByIdAndNamePropAbp(Integer.parseInt(poPriceId), Constant.PAYMENT_TIMING);
//		KeyValueType rentDue = new KeyValueType();
//		rentDue.setKey(poPriceId);
//		rentDue.setValue(priceLst.get(0).getValueAbp());
		
		return Arrays.asList(kvtPPF, kvtPenalty);
	}

	/**
	 * Metodo que retorna la respuesta del servicio de AMDOCS si cumple con los
	 * parametros.
	 * 
	 * @param
	 * @return DevicePenaltyInfo
	 */
	private DevicePenaltyInfo ifCallPenalty(MobileElegibleOffersRequest meor, String billingMethod) {

		DevicePenaltyInfo dpi = new DevicePenaltyInfo();

		if (!Constant.PROVIDE.equals(meor.getAction()) && !Constant.PREPAID.equals(billingMethod)) {
			try {
				return penalty.consult(meor.getProductPublicId()).getRetrieveCommitmentPenaltyResponseData()
						.getDevicePenaltyInfo();
			} catch (DatatypeConfigurationException e) {
				e.printStackTrace();
			}
		}

		return dpi;
	}

	/**
	 * Obtiene el productOfferingProductSpecID de children
	 * 
	 * @param offerType
	 * @return
	 */
	private String getProductOfferingProductSpecID(OfferingTypeOfferType offerType) {
		if (!offerType.getChildren().isEmpty()) {
			return offerType.getChildren().get(0).getProductOfferingProductSpecID();
		}
		return null;
	}

	/**
	 * Obtiene solo los priceDetails Recurrentes
	 * 
	 * @param pBOdt
	 * @return
	 */
	private PriceDetailsType getPriceDetails(PlanBODetailsType pBOdt) {
		return pBOdt.getPriceDetails().stream().filter(
				pdt -> Util.enumEquivalence(pdt.getPriceType()).toString().equals(PriceTypeEnum.RECURRING.toString()))
				.findAny().orElse(null);
	}

}
