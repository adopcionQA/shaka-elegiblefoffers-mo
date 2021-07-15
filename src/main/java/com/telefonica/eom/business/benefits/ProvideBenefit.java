package com.telefonica.eom.business.benefits;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.BenefitsQueries;
import com.telefonica.eom.business.benefits.interfaces.IProvideBenefit;
import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.entity.ProvideBenefits;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.generated.offers.model.CharacteristicBenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.repository.ProvideBenefitsRepo;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ProvideBenefit.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Clase Service que contiene los metodos necesarios para obtener la lista de beneficios.
*/
@Service
public class ProvideBenefit implements IProvideBenefit {

    @Autowired
    BenefitsQueries benefitsQueries;

    @Autowired
    ProvideBenefitsRepo provideBenefitsRepo;

    /**
     * Metodo que retorna una lista de BenefitType de acuerdo a parametros enviados.
     * 
     * @param BusinessReference,String,String,String
     * @return List<BenefitType>
     */
    public List<BenefitType> getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemCode,
	    String catalogItemId) {
	
	return benefitsRef.getPlanBORefList().stream()
		.filter(refplan -> catalogItemCode.equals(refplan.getCatalogItemCode()))
		.filter(refplan -> billingOfferCode.equals(refplan.getBillingOfferCode()))
		.filter(refplan -> catalogItemId.equals(refplan.getCatalogItemId()))
		.findAny().get()
		.getProvideBenefitsList()
		.stream()
		.map(pb -> this.getBenefit(pb, benefitsRef.getBillingOfferMasterList(), benefitsRef.getBenefitsPropertyInBillingOfferList()))
		.collect(Collectors.toList());
    }
    
    /**
     * Metodo que retorna un objeto BenefitType de acuerdo a parametros enviados.
     * 
     * @param ProvideBenefits,List<BillingOfferMaster>, List<PropertyInBillingOffer>
     * @return BenefitType
     */
    private BenefitType getBenefit(ProvideBenefits pb, List<BillingOfferMaster> bomList, List<PropertyInBillingOffer> piboList) {
	
	BenefitType bt = new BenefitType();
	CharacteristicBenefitType chbt = new CharacteristicBenefitType();
	
	bt.setId(pb.getBoCode());
	bt.setName(benefitsQueries.getNameBO(pb.getBoCode(), bomList));
	chbt.setKey("duration");
	chbt.setValue(benefitsQueries.getDurationValue(pb.getBoCode(), piboList));
	bt.setCharacteristics(Arrays.asList(chbt));
	return bt;
    }
    
    /**
     * Metodo que retorna una lista de ProvideBenefits de acuerdo a parametros enviados.
     * 
     * @param MobileElegibleOffersRequest,String,String,String
     * @return List<ProvideBenefits>
     */
    public List<ProvideBenefits> getALTABenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemCode,
	    String catalogItemId) {
	
	String planGroup = benefitsQueries.getPlanGroup(billingOfferCode, catalogItemId);
	
	return provideBenefitsRepo
		.findByQueryParamFilters(meor.getCustomerSegment(), benefitsQueries.getCustomerSubType(meor), meor.getChannelId(),
			meor.getRegion(), meor.getDealerId(), meor.getSiteId(), LocalDateTime.now()).stream()
        	.filter(pb -> planGroup.equals(pb.getPlanGroup()))
        	.filter(pb -> catalogItemCode.equals(pb.getProductOfferCode()))
        	.filter(pb -> billingOfferCode.equals(pb.getPlanBoCode()))
        	.collect(Collectors.toList());
    }

}
