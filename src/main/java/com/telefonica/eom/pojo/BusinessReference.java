package com.telefonica.eom.pojo;

import java.util.List;

import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.entity.TbearlyCaeqParam;

import lombok.Data;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: BusinessReference.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Pojo del objeto BusinessReference.
 */
@Data
public class BusinessReference {

	//este es el que cicla por que ?
    List<PlanBOReference>	 planBORefList;
    List<BillingOfferMaster>	 billingOfferMasterList;
    List<PropertyInBillingOffer> benefitsPropertyInBillingOfferList;
    List<PropertyInBillingOffer> penaltyPropertyInBillingOfferList;
    List<TbearlyCaeqParam>	 tbearlyCaeqParamList;

}
