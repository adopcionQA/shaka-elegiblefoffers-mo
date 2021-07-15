package com.telefonica.eom.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.benefits.interfaces.IPortabilityBenefit;
import com.telefonica.eom.business.benefits.interfaces.IProvideBenefit;
import com.telefonica.eom.business.benefits.interfaces.IReplaceBenefit;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.entity.PortabilityBenefits;
import com.telefonica.eom.entity.ProvideBenefits;
import com.telefonica.eom.entity.ReplaceOfferBenefits;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.pojo.PlanBOReference;
import com.telefonica.eom.repository.BillingOfferMasterRepo;
import com.telefonica.eom.repository.PropertyInBillingOfferRepo;
import com.telefonica.eom.repository.TbearlyCaeqParamRepo;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryListType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.OfferingTypeOfferType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PlanBODetailsType;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: PlanBoDetailsBusinessMapper.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service para generar objeto del PlanBoDetailsBusiness.
 * 
 */
@Service
public class PlanBoDetailsBusinessMapper {

	@Autowired
	IReplaceBenefit replaceBenefit;

	@Autowired
	IProvideBenefit provideBenefit;

	@Autowired
	IPortabilityBenefit portabilityBenefit;

	@Autowired
	BillingOfferMasterRepo billingOfferMasterRepo;

	@Autowired
	PropertyInBillingOfferRepo propertyInBillingOfferRepo;

	@Autowired
	TbearlyCaeqParamRepo tbearlyCaeqParamRepo;

	/**
	 * Metodo que retorna un objeto BusinessReference.
	 * 
	 * @param MobileElegibleOffersRequest, List<CategoryListType>
	 * @return BusinessReference
	 */
	public BusinessReference fromOfferingsAMDOCStoReference(MobileElegibleOffersRequest meor, List<CategoryListType> categories) {

		List<PlanBOReference> planBORefList = new ArrayList<>();
		List<String> boCodeList = new ArrayList<>();
		List<String> productOfferingPriceIdList = new ArrayList<>();
		String catalogItemCode;
		String catalogItemId;
		boolean penaltycond;

		BusinessReference br = new BusinessReference();
		
		for (CategoryListType category: categories) {
			for (OfferingTypeOfferType offerType: category.getOfferings()) {
				catalogItemCode = offerType.getCatalogItemCode();
				catalogItemId = offerType.getCatalogItemId();
				
				penaltycond = ifAddPriceId(meor,offerType.getPlanType());
				
				for (PlanBODetailsType pBOdt: offerType.getPlanBoList()) {
					plaBOLevel(pBOdt, penaltycond, meor, planBORefList, boCodeList, productOfferingPriceIdList, catalogItemCode, catalogItemId);
				}
			}
		}

		br.setPlanBORefList(planBORefList);
		//BILLING_OFFER_MASTER
		br.setBillingOfferMasterList(billingOfferMasterRepo.findByCaptionBOIn(boCodeList));
		//PROPERTY_IN_BILLING_OFFER
		br.setBenefitsPropertyInBillingOfferList(propertyInBillingOfferRepo.findByCaptionBoIn(boCodeList));
		
		ifgetPenaltyPIBOList(br, productOfferingPriceIdList);

		return br;
	}
	
	/**
	 * Metodo auxiliar
	 * 
	 * @param PlanBODetailsType, boolean, MobileElegibleOffersRequest, List<PlanBOReference>, List<String>, List<String>, String, String
	 * @return 
	 */
	private void plaBOLevel(PlanBODetailsType pBOdt, boolean penaltycond, MobileElegibleOffersRequest meor, List<PlanBOReference> planBORefList, List<String> boCodeList, List<String> productOfferingPriceIdList, String catalogItemCode, String catalogItemId) {

		PlanBOReference pBOr = new PlanBOReference();

		pBOr.setCatalogItemCode(catalogItemCode);
		pBOr.setCatalogItemId(catalogItemId);
		pBOr.setBillingOfferCode(pBOdt.getBillingOfferCode());
		//moises
		pBOr.setPriceDetails(pBOdt.getPriceDetails());
		if (penaltycond) {
			productOfferingPriceIdList.add(pBOdt.getBillingOfferId());
		}

		if (Constant.CHANGE.equals(meor.getAction())) {

			List<ReplaceOfferBenefits> list = replaceBenefit.getROBenefits(meor, pBOdt.getBillingOfferCode(),
					catalogItemCode);
			pBOr.setReplaceOfferBenefitsList(list);

			boCodeList.addAll(list.stream().map(ReplaceOfferBenefits::getBoCode).collect(Collectors.toList()));
		} else {
			List<ProvideBenefits> list = provideBenefit.getALTABenefits(meor, pBOdt.getBillingOfferCode(),
					catalogItemCode, catalogItemId);
			pBOr.setProvideBenefitsList(list);

			if (list != null) {
				boCodeList.addAll(list.stream().map(ProvideBenefits::getBoCode).collect(Collectors.toList()));
			}
			if (Boolean.TRUE.equals(meor.getIsPortability())) {
				//aqui se setea los portabilityBenefits
				PortabilityBenefits pb = portabilityBenefit.getPORTBenefits(meor, pBOdt.getBillingOfferCode(),
						catalogItemId);
				pBOr.setPortabilityBenefits(pb);

				boCodeList.add(pb.getBoCode());
			}
		}
		
		planBORefList.add(pBOr);
		
	}

	/**
	 * Metodo auxiliar
	 * 
	 * @param BusinessReference, List<String>
	 * @return
	 */
	private void ifgetPenaltyPIBOList(BusinessReference br, List<String> productOfferingPriceIdList) {
		if (!productOfferingPriceIdList.isEmpty()) {
			br.setPenaltyPropertyInBillingOfferList(propertyInBillingOfferRepo
					.findByCidBoInAndPropertyName(productOfferingPriceIdList, Constant.PLAN_RANK));
			br.setTbearlyCaeqParamList(tbearlyCaeqParamRepo.findAll());
		}
	}

	/**
	 * Metodo auxiliar retorna true|false de acuerdo a validaciones.
	 * 
	 * @param MobileElegibleOffersRequest, String
	 * @return boolean
	 */
	private boolean ifAddPriceId(MobileElegibleOffersRequest meor, String billingMethod) {
		boolean cond = false;

		if (!Constant.PROVIDE.equals(meor.getAction()) && !Constant.PREPAID.equals(billingMethod)) {
			cond = true;
		}
		return cond;
	}

}
