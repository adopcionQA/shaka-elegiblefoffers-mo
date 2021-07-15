package com.telefonica.eom.business.benefits.interfaces;

import java.util.List;

import com.telefonica.eom.entity.ProvideBenefits;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: IProvideBenefit.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Interfaz que sera implementada por la clase ProvideBenefit.
*/
public interface IProvideBenefit {

    List<BenefitType> getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemCode, String catalogItemId);

    List<ProvideBenefits> getALTABenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemCode,
	    String catalogItemId);

}