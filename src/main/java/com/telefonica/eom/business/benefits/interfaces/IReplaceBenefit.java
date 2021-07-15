package com.telefonica.eom.business.benefits.interfaces;

import java.util.List;


import com.telefonica.eom.entity.ReplaceOfferBenefits;
import com.telefonica.eom.generated.offers.model.BenefitType;
import com.telefonica.eom.pojo.BusinessReference;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: IReplaceBenefit.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Interfaz que sera implementada por la clase ReplaceBenefit.
*/
public interface IReplaceBenefit {

    List<BenefitType> getBenefits(BusinessReference benefitsRef, String billingOfferCode, String catalogItemCode);

    List<ReplaceOfferBenefits> getROBenefits(MobileElegibleOffersRequest meor, String billingOfferCode, String catalogItemCode);

    List<ReplaceOfferBenefits> preFilteredList(MobileElegibleOffersRequest meor);

}