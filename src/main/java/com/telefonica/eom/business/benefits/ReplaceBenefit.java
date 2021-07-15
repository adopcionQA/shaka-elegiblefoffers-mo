package com.telefonica.eom.business.benefits;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.BenefitsQueries;
import com.telefonica.eom.business.benefits.interfaces.IReplaceBenefit;
import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.entity.ReplaceOfferBenefits;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.generated.offers.model.CharacteristicBenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.repository.ReplaceOfferBenefitsRepo;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ReplaceBenefit.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Clase Service que contiene los metodos necesarios para obtener la lista de beneficios.
*/
@Service
public class ReplaceBenefit implements IReplaceBenefit {
    
    @Autowired
    BenefitsQueries benefitsQueries;
    
    @Autowired
    ReplaceOfferBenefitsRepo replaceOfferBenefitsRepo;
    
   @Autowired
   IReplaceBenefit replaceBenefit;
    
   /**
    * Metodo que retorna una lista de BenefitType de acuerdo a parametros enviados.
    * 
    * @param BusinessReference,String,String
    * @return List<BenefitType> 
    */
   public List<BenefitType> getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemCode){
       
       return benefitsRef.getPlanBORefList().stream()
       .filter(refplan -> catalogItemCode.equals(refplan.getCatalogItemCode()))
       .filter(refplan -> billingOfferCode.equals(refplan.getBillingOfferCode()))
       .findAny().get()
       .getReplaceOfferBenefitsList()
       .stream()
       .map(rob -> this.getBenefit(rob, benefitsRef.getBillingOfferMasterList(),
	       benefitsRef.getBenefitsPropertyInBillingOfferList()))
       .collect(Collectors.toList());
   }
    
   /**
    * Metodo que retorna un objeto BenefitType de acuerdo a parametros enviados.
    * 
    * @param ReplaceOfferBenefits,List<BillingOfferMaster>, List<PropertyInBillingOffer>
    * @return BenefitType
    */
   private BenefitType getBenefit(ReplaceOfferBenefits rob, List<BillingOfferMaster> bomList, List<PropertyInBillingOffer> piboList) {
	
	BenefitType bt = new BenefitType();
	CharacteristicBenefitType chbt = new CharacteristicBenefitType();
	
	bt.setId(rob.getBoCode());
	bt.setName(benefitsQueries.getNameBO(rob.getBoCode(), bomList));
	chbt.setKey("duration");
	chbt.setValue(benefitsQueries.getDurationValue(rob.getBoCode(), piboList));
	bt.setCharacteristics(Arrays.asList(chbt));
	return bt;
    }

   /**
    * Metodo que retorna una lista de ReplaceOfferBenefits de acuerdo a parametros enviados.
    * 
    * @param MobileElegibleOffersRequest,String,String
    * @return List<ReplaceOfferBenefits>
    */
    public List<ReplaceOfferBenefits> getROBenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemCode){
	
	return replaceBenefit.preFilteredList(meor).stream()
		.filter(rob -> catalogItemCode.equals(rob.getTargetProdOfferCode()))
		.filter(rob -> billingOfferCode.equals(rob.getTargetPlanBOCode()))
		.collect(Collectors.toList());
    }
    
    /**
     * Metodo que retorna una lista de ReplaceOfferBenefits de acuerdo a parametros enviados.
     * 
     * @param MobileElegibleOffersRequest
     * @return List<ReplaceOfferBenefits>
     */
    //@Cacheable(value = "CHList", key = "#meor")
    @Cacheable(value = "replace_offer_benefits", unless = "#result == null or #result.size() == 0")
    public List<ReplaceOfferBenefits> preFilteredList(MobileElegibleOffersRequest meor) {
	
	String offerCaption = benefitsQueries.getOfferCaption(meor);
	String captionBO = benefitsQueries.getCaptionBO(meor.getPlanId());
	String customerSubType = benefitsQueries.getCustomerSubType(meor);
	
	return replaceOfferBenefitsRepo.findByQueryParamFilters(meor.getCustomerSegment(), customerSubType, meor.getSubscriberGroupValue(),
		offerCaption, captionBO, meor.getChannelId(), meor.getRegion(), meor.getDealerId(), meor.getSiteId(), LocalDate.now());
    }

}
