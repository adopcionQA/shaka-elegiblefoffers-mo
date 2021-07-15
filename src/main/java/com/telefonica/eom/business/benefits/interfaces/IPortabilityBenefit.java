package com.telefonica.eom.business.benefits.interfaces;

import java.util.List;

import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.PortabilityBenefits;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: IPortabilityBenefit.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Interfaz que sera implementada por la clase PortabilityBenefit.
*/
public interface IPortabilityBenefit {

    BenefitType getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemId);
    
    BenefitType getPortabilityBenefits(  MobileElegibleOffersRequest meor ,BusinessReference benefitsRef, String billingOfferCode, String catalogItemId) ;

    PortabilityBenefits getPORTBenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemId);

    List<PortabilityBenefits> preFilteredList(MobileElegibleOffersRequest meor);

}