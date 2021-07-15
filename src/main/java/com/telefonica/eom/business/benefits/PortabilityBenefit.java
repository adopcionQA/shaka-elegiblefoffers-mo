package com.telefonica.eom.business.benefits;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.BenefitsQueries;
import com.telefonica.eom.business.benefits.interfaces.IPortabilityBenefit;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.PortabilityBenefits;
import com.telefonica.eom.entity.PriceProperties;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.entity.RelationsMaster;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.generated.offers.model.CharacteristicBenefitType;
import com.telefonica.eom.generated.offers.model.MoneyType;
import com.telefonica.eom.generated.offers.model.PriceBenefitType;
import com.telefonica.eom.jdbc.BenefitPortability;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.pojo.PlanBOReference;
import com.telefonica.eom.repository.BillingOfferMasterRepo;
import com.telefonica.eom.repository.PortabilityBenefitsRepo;
import com.telefonica.eom.repository.PricePropertiesRepo;
import com.telefonica.eom.repository.PropertyInBillingOfferRepo;
import com.telefonica.eom.repository.RelationsMasterRepo;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: PortabilityBenefit.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que contiene los metodos necesarios para obtener
 *               la lista de beneficios de Portabilidad.
 */
@Service
public class PortabilityBenefit implements IPortabilityBenefit {

    @Autowired
    BenefitsQueries benefitsQueries;

    @Autowired
    PortabilityBenefitsRepo portabilityBenefitsRepo;

    @Autowired
    IPortabilityBenefit portabilityBenefit;

    @Autowired
    private BenefitPortability benefitPortabilityJdbc;

    @Autowired
    private BillingOfferMasterRepo billingOfferMasterRepo;

    @Autowired
    private PropertyInBillingOfferRepo propertyInBillingOfferRepo;

    @Autowired
    private PricePropertiesRepo pricePropertiesRepo;

    @Autowired
    private RelationsMasterRepo relationsMasterRepo;

    private List<PortabilityBenefits> ageInDonorAsterisk;
    private List<PortabilityBenefits> ageInDonorValue;

    /**
     * Metodo que retorna un objeto BenefitType de acuerdo a parametros enviados.
     * 
     * @param BusinessReference,String,String
     * @return BenefitType
     */
    public BenefitType getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemId) {

	PortabilityBenefits pb = benefitsRef.getPlanBORefList().stream()
		.filter(refplan -> billingOfferCode.equals(refplan.getBillingOfferCode()))
		.filter(refplan -> catalogItemId.equals(refplan.getCatalogItemId())).findAny().get().getPortabilityBenefits();

	return this.getBenefit(pb, benefitsRef.getBillingOfferMasterList(), benefitsRef.getBenefitsPropertyInBillingOfferList());
    }

    /**
     * Metodo que retorna un objeto BenefitType de acuerdo a parametros enviados.
     * 
     * @param PortabilityBenefits,
     *            List<BillingOfferMaster>, List<PropertyInBillingOffer>
     * @return BenefitType
     */
    private BenefitType getBenefit(PortabilityBenefits pb, List<BillingOfferMaster> bomList, List<PropertyInBillingOffer> piboList) {

	BenefitType bt = new BenefitType();
	CharacteristicBenefitType chbt = new CharacteristicBenefitType();

	if (!(bomList == null || bomList.isEmpty())) {
	    bt.setId(pb.getBoCode());
	    bt.setName(benefitsQueries.getNameBO(pb.getBoCode(), bomList));
	    chbt.setKey(Constant.DURATION);
	    chbt.setValue(benefitsQueries.getDurationValue(pb.getBoCode(), piboList));
	    bt.setCharacteristics(Arrays.asList(chbt));
	}

	return bt;
    }

    /**
     * Metodo que retorna un objeto PortabilityBenefits de acuerdo a parametros
     * enviados.
     * 
     * @param MobileElegibleOffersRequest,
     *            String, String
     * @return PortabilityBenefits
     */
    public PortabilityBenefits getPORTBenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemId) {

	String planGroup = benefitsQueries.getPlanGroup(billingOfferCode, catalogItemId);
	PortabilityBenefits pbenefit = new PortabilityBenefits();

	Optional<PortabilityBenefits> pbOptional = portabilityBenefit.preFilteredList(meor).stream()
		.filter(pb -> planGroup.equals(pb.getPlanGroup())).filter(pb -> billingOfferCode.equals(pb.getPlanBoCode())).findFirst();

	if (pbOptional.isPresent()) {
	    pbenefit = pbOptional.get();
	}

	return pbenefit;
    }

    /**
     * Metodo que retorna una lista de PortabilityBenefits de acuerdo a parametros
     * enviados.
     * 
     * @param MobileElegibleOffersRequest
     * @return List<PortabilityBenefits>
     */
    // @Cacheable(value = "PORTList", key = "#meor")
    @Cacheable(value = "portability_benefits", unless = "#result == null or #result.size() == 0")
    public List<PortabilityBenefits> preFilteredList(MobileElegibleOffersRequest meor) {

	ageInDonorAsterisk = new ArrayList<>();
	ageInDonorValue = new ArrayList<>();

	String customerSubType = benefitsQueries.getCustomerSubType(meor);

	DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;

	LocalDate date = LocalDate.parse(meor.getPortabilityCustomerSince(), formatter);

	Long portabilityCustomerSince = Util.getMonthsPeriod(date);

	portabilityBenefitsRepo
		.findByQueryParamFilters(meor.getCustomerSegment(), customerSubType, meor.getPortabilityCurrentPlanType(),
			meor.getPortabilityCurrentCompany(), meor.getChannelId(), meor.getSiteId(), meor.getDealerId(), meor.getRegion())
		.stream().forEach(pb -> this.ageInDonor(pb, portabilityCustomerSince));

	ageInDonorValue.stream().sorted(Comparator.comparing(PortabilityBenefits::getAgeInDonor).reversed()).collect(Collectors.toList())
		.addAll(ageInDonorAsterisk);

	return ageInDonorValue;
    }

    /**
     * Metodo utilitario.
     * 
     * @param PortabilityBenefits,Long
     * @return
     */
    private void ageInDonor(PortabilityBenefits pb, Long portabilityCustomerSince) {

	if (Constant.ASTERISK.equals(pb.getAgeInDonor())) {
	    ageInDonorAsterisk.add(pb);
	} else {
	    if (Integer.valueOf(pb.getAgeInDonor()) <= portabilityCustomerSince) {
		ageInDonorValue.add(pb);
	    }
	}
    }

    @Override
    public BenefitType getPortabilityBenefits(MobileElegibleOffersRequest meor, BusinessReference benefitsRef, String billingOfferCode,
	    String catalogItemId) {

	List<CharacteristicBenefitType> characteristicsList = new ArrayList<>();

	BenefitType bt = new BenefitType();

	List<RelationsMaster> relationBenefits = benefitPortabilityJdbc.getRelations(meor, catalogItemId);
	if (!relationBenefits.isEmpty() && relationBenefits.size() == 1) {
	    String billingOfferDiscount = relationBenefits.get(0).getChildId();
	    bt.setId(billingOfferDiscount);
	    List<BillingOfferMaster> billingOfferMaster = billingOfferMasterRepo.findByCidBO(billingOfferDiscount);
	    if (!billingOfferMaster.isEmpty()) {
		bt.setName(billingOfferMaster.get(0).getNameBO());
	    } else {
		bt.setName(null);
	    }
	    bt.setType(Constant.MOBILE);

	    String durationValue = null;

	    List<PropertyInBillingOffer> pbolist = propertyInBillingOfferRepo.findByCidBo(billingOfferDiscount);
	    if (!pbolist.isEmpty()) {
		durationValue = pbolist.get(0).getDurationValue();
	    }

	    if (Objects.nonNull(durationValue)) {
		CharacteristicBenefitType chbt = new CharacteristicBenefitType();
		chbt.setKey(Constant.DURATION);
		chbt.setValue(durationValue);
		characteristicsList.add(chbt);

	    }
	    List<PlanBOReference> planBOReferenceList = benefitsRef.getPlanBORefList().stream()
		    .filter(x -> x.getBillingOfferCode().equalsIgnoreCase(billingOfferCode))
		    .filter(refplan -> catalogItemId.equals(refplan.getCatalogItemId())).collect(Collectors.toList());

	    List<PriceBenefitType> listPriceBenefits = getPriceBenefitsList(billingOfferDiscount, planBOReferenceList, characteristicsList);
	    bt.setPriceBenefits(listPriceBenefits);
	    // Poblar id de relacion de la BO y el componente padre
	    List<String> childIds = new ArrayList<>();
	    childIds.add(Constant.VAL_6821);
	    List<RelationsMaster> relationMasters = relationsMasterRepo.findByRootCidAndChildIdIn(catalogItemId, childIds);
	    String relationId = Constant.EMPTY;
	    if (relationMasters.isEmpty() || Objects.isNull(relationMasters.get(0).getRelationId())
		    || relationMasters.get(0).getRelationId().isEmpty()) {

		relationId = benefitPortabilityJdbc.getRelationId(catalogItemId);

	    }
	    CharacteristicBenefitType productSpecContaimentID = new CharacteristicBenefitType();
	    productSpecContaimentID.setKey(Constant.PRODUCT_SPEC_CONTAIMENT_ID);
	    productSpecContaimentID.setValue(relationId);
	    characteristicsList.add(productSpecContaimentID);
	    // Poblar id de relacion de la BO de descuento
	    List<String> billingOfferIds = new ArrayList<>();
	    billingOfferIds.add(billingOfferDiscount);
	    List<RelationsMaster> idBoDiscount = relationsMasterRepo.findByRootCidAndChildIdIn(catalogItemId, billingOfferIds);
	    CharacteristicBenefitType pricePlanSpecContainmentID = new CharacteristicBenefitType();
	    pricePlanSpecContainmentID.setKey(Constant.PRICE_PLAN_SPEC_CONTAIMENT_ID);
	    if (!idBoDiscount.isEmpty()) {
		pricePlanSpecContainmentID.setValue(idBoDiscount.get(0).getRelationId());
	    } else {
		pricePlanSpecContainmentID.setValue(null);
	    }

	    characteristicsList.add(pricePlanSpecContainmentID);
	    bt.setCharacteristics(characteristicsList);

	}

	return bt;
    }

    private List<PriceBenefitType> getPriceBenefitsList(String billingOfferDiscount, List<PlanBOReference> planBOReferenceList,
	    List<CharacteristicBenefitType> characteristicsList) {

	List<PriceProperties> pricePropetiesList = pricePropertiesRepo.findByBillingOfferId(billingOfferDiscount);
	String discountType = pricePropetiesList.stream().filter(x -> Constant.DISCOUNT_TYPE.equalsIgnoreCase(x.getNamePropAbp()))
		.map(PriceProperties::getValueAbp).findFirst().orElse(null);
	String discountValue = pricePropetiesList.stream().filter(x -> Constant.DISCOUNT_VALUE.equalsIgnoreCase(x.getNamePropAbp()))
		.map(PriceProperties::getValueAbp).findFirst().orElse(Constant.ZERO);
	String revenueType = null;

	if (!pricePropetiesList.isEmpty() && Constant.RC.equalsIgnoreCase(pricePropetiesList.get(0).getRevenueType())) {
	    revenueType = Constant.RENUEVE_TYPE_RECURRING;
	} else {
	    revenueType = Constant.RENUEVE_TIPE_ONE_TIME;
	}

	List<PriceBenefitType> priceBenefitsList = new ArrayList<>();
	if (Objects.nonNull(discountType) && !discountType.isEmpty()) {

	    for (PlanBOReference planBOReferenceF : planBOReferenceList) {

		for (PriceDetailsType priceDetailsTypeF : planBOReferenceF.getPriceDetails()) {

		    PriceBenefitType priceBenefitType = new PriceBenefitType();
		    priceBenefitType.setPriceType(revenueType);
		    BigDecimal discountMontBigD;
		    BigDecimal discountValBigD = new BigDecimal(discountValue);
		    if (Constant.PERCENT.equalsIgnoreCase(discountType)) {

			discountMontBigD = priceDetailsTypeF.getOriginalAmount().getAmount().multiply(discountValBigD)
				.divide(new BigDecimal(Constant.VALUE_100));

		    } else {
			discountMontBigD = discountValBigD;
		    }
		    MoneyType price = new MoneyType();

		    price.setAmount(discountMontBigD);
		    price.setUnits(Constant.PERUVIAN_COIN);
		    MoneyType priceWithTax = new MoneyType();
		    priceWithTax.setAmount(discountMontBigD.multiply(new BigDecimal(Constant.VALUE_IGV)));
		    priceWithTax.setUnits(Constant.PERUVIAN_COIN);
		    priceBenefitType.setPrice(price);
		    priceBenefitType.setPriceWithTax(priceWithTax);

		    priceBenefitsList.add(priceBenefitType);

		}
	    }
	    CharacteristicBenefitType characterisctic = new CharacteristicBenefitType();
	    characterisctic.setKey(Constant.IS_PROVISIONABLE);
	    characterisctic.setValue(Constant.TRUE);
	    characteristicsList.add(characterisctic);

	}

	return priceBenefitsList;

    }
}
