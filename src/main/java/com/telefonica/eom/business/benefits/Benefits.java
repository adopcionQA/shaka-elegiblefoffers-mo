package com.telefonica.eom.business.benefits;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.benefits.interfaces.IPortabilityBenefit;
import com.telefonica.eom.business.benefits.interfaces.IProvideBenefit;
import com.telefonica.eom.business.benefits.interfaces.IReplaceBenefit;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: Benefits.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Clase Service que contiene los metodos necesarios para obtener la lista de beneficios.
*/
@Service
public class Benefits {

    @Autowired
    IReplaceBenefit replaceBenefits;
    
    @Autowired
    IProvideBenefit provideBenefit;
    
    @Autowired
    IPortabilityBenefit portabilityBenefit;

    
    /**
     * Metodo que retorna una lista de BenefitType.
     * 
     * @param MobileElegibleOffersRequest,BusinessReference,String,String,String
     * @return List<BenefitType>
     */
    public List<BenefitType> benefistsList(MobileElegibleOffersRequest meor, BusinessReference benefitsRef, String catalogItemCode,
	    String catalogItemId, String billingOfferCode) {

	if (Constant.CHANGE.equals(meor.getAction())) {
	    
	    return replaceBenefits.getBenefits(benefitsRef, billingOfferCode, catalogItemCode);
	    
	} else {
	    
	    List<BenefitType> altaBenefits = provideBenefit.getBenefits(benefitsRef, billingOfferCode, catalogItemCode, catalogItemId);
	    
	    
	    if(Boolean.TRUE.equals(meor.getIsPortability())){
		altaBenefits.add(portabilityBenefit.getBenefits(benefitsRef, billingOfferCode, catalogItemId));
		altaBenefits.add(portabilityBenefit.getPortabilityBenefits(meor, benefitsRef, billingOfferCode, catalogItemId)) ;
	    }
	    
	    return altaBenefits;
	}
    }

}
