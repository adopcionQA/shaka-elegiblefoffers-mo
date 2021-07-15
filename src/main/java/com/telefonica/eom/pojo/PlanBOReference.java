package com.telefonica.eom.pojo;

import java.util.List;

import com.telefonica.eom.entity.PortabilityBenefits;
import com.telefonica.eom.entity.ProvideBenefits;
import com.telefonica.eom.entity.ReplaceOfferBenefits;
import com.telefonica.globalintegration.services.retrieveofferings.v1.PriceDetailsType;

import lombok.Data;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: PlanBOReference.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Pojo del objeto PlanBOReference.
 */
@Data
public class PlanBOReference {

	private String catalogItemCode;
	private String catalogItemId;
	private String billingOfferCode;
	private List<ReplaceOfferBenefits> replaceOfferBenefitsList;
	private List<ProvideBenefits> provideBenefitsList;
	private PortabilityBenefits portabilityBenefits;
	
	private List<PriceDetailsType> priceDetails;
}
