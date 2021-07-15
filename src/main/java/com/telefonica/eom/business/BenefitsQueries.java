package com.telefonica.eom.business;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.entity.BillingOfferMaster;
import com.telefonica.eom.entity.MasterOfOffers;
import com.telefonica.eom.entity.OffersProperties;
import com.telefonica.eom.entity.PropertyInBillingOffer;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.repository.BillingOfferMasterRepo;
import com.telefonica.eom.repository.MasterOfOffersRepo;
import com.telefonica.eom.repository.OffersPropertiesRepo;
import com.telefonica.eom.repository.PropertyInBillingOfferRepo;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: BenefitsQueries.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los métodos necesarios para consultar los querys de
 *               Benefits.
 */
@Service
public class BenefitsQueries {

	@Autowired
	MasterOfOffersRepo masterOfOffersRepo;

	@Autowired
	BillingOfferMasterRepo billingOfferMasterRepo;

	@Autowired
	PropertyInBillingOfferRepo propertyInBillingOfferRepo;

	@Autowired
	OffersPropertiesRepo offersPropertiesRepo;

	/**
	 * Metodo que retorna NameBo de BillingOfferMaster
	 * 
	 * @param String,List<BillingOfferMaster>
	 * @return String
	 */
	public String getNameBO(String boCode, List<BillingOfferMaster> bomList) {
		return bomList.stream().filter(bom -> boCode.equals(bom.getCaptionBO())).findAny().get().getNameBO();
	}

	/**
	 * Metodo que retorna DurationValue de PropertyInBillingOffer
	 * 
	 * @param String,List<PropertyInBillingOffer>
	 * @return String
	 */
	public String getDurationValue(String boCode, List<PropertyInBillingOffer> piboList) {

		return piboList.stream().filter(pibo -> boCode.equals(pibo.getCaptionBo())).findAny().get().getDurationValue();
	}

	/**
	 * Metodo que retorna CaptionBO de BillingOfferMaster
	 * 
	 * @param String
	 * @return String
	 */
	public String getCaptionBO(String planId) {//
		String captionBO = null;

		Optional<BillingOfferMaster> bomOptional = billingOfferMasterRepo.findByCidBO(planId).stream().findAny();

		if (bomOptional.isPresent()) {
			captionBO = bomOptional.get().getCaptionBO();
		}

		return captionBO;
	}

	/**
	 * Metodo que retorna OfferCaption de MasterOfOffers
	 * 
	 * @param MobileElegibleOffersRequest
	 * @return String
	 */
	public String getOfferCaption(MobileElegibleOffersRequest meor) {
		String offerCaption = null;

		Optional<MasterOfOffers> mooOptional = masterOfOffersRepo.findByOfferCid(meor.getCurrentOffering()).stream()
				.findAny();

		if (mooOptional.isPresent()) {
			offerCaption = mooOptional.get().getOfferCaption();
		}
		return offerCaption;
	}

	/**
	 * Metodo que retorna el Subtipo de Customer de acuerdo a filtros.
	 * 
	 * @param MobileElegibleOffersRequest
	 * @return String
	 */
	public String getCustomerSubType(MobileElegibleOffersRequest meor) {

		if (Constant.VOID_STRING.equals(meor.getCustomerSegment()) || null == meor.getCustomerSubsegment()) {
			return Constant.RNU;
		} else {
			return meor.getCustomerSubsegment();
		}
	}

	/**
	 * Metodo que retorna el plangroup de acuerdo a filtros.
	 * 
	 * @param String,String
	 * @return String
	 */
	public String getPlanGroup(String billingOfferCode, String catalogItemId) {
		String plangroup;

		plangroup = this.getPropertyValueFromPIBO(billingOfferCode, Constant.PLAN_GROUP);

		if (Constant.VOID_STRING.equals(plangroup) || plangroup == null) {
			plangroup = this.getPropertyValueFromOP(catalogItemId, Constant.PLAN_GROUP);
		}

		if (plangroup == null) {
			return Constant.VOID_STRING;
		}

		return plangroup;
	}

	/**
	 * Metodo que retorna el plangroup de acuerdo a filtros.
	 * 
	 * @param String,String
	 * @return String
	 */
	public String getPropertyValue(String planId, String productOfferingCatalogId) {
		String pv;

		pv = this.getPropertyValueFromPIBOByCidBO(planId, Constant.PLAN_GROUP);

		if (Constant.VOID_STRING.equals(pv) || pv == null) {
			pv = this.getPropertyValueFromOP(productOfferingCatalogId, Constant.PLAN_GROUP);
		}

		return pv;
	}

	/**
	 * Metodo que retorna el PropertyValue de PropertyInBillingOffer de acuerdo a
	 * filtros.
	 * 
	 * @param String,String
	 * @return String
	 */
	private String getPropertyValueFromPIBO(String captionBo, String propertyName) {
		String pv = Constant.VOID_STRING;// freddy

		Optional<PropertyInBillingOffer> piboOptional = propertyInBillingOfferRepo
				.findByCaptionBoAndPropertyName(captionBo, propertyName).stream().findAny();

		if (piboOptional.isPresent()) {
			pv = piboOptional.get().getPropertyValue();
		}

		return pv;
	}

	/**
	 * Metodo que retorna el PropertyValue de PropertyInBillingOffer de acuerdo a
	 * filtros.
	 * 
	 * @param String,String
	 * @return String
	 */
	private String getPropertyValueFromPIBOByCidBO(String cidBo, String propertyName) {
		String pv = null;

		Optional<PropertyInBillingOffer> piboOptional = propertyInBillingOfferRepo
				.findByCidBoAndPropertyName(cidBo, propertyName).stream().findAny();

		if (piboOptional.isPresent()) {
			pv = piboOptional.get().getPropertyValue();
		}

		return pv;
	}

	/**
	 * Metodo que retorna el PropertyValue de OffersProperties de acuerdo a filtros.
	 * 
	 * @param String,String
	 * @return String
	 */
	private String getPropertyValueFromOP(String offerCid, String nameOfProperty) {
		String pv = Constant.VOID_STRING;// freddy

		Optional<OffersProperties> piboOptional = offersPropertiesRepo
				.findByOfferCidAndNameOfProperty(offerCid, nameOfProperty).stream().findAny();

		if (piboOptional.isPresent()) {
			pv = piboOptional.get().getPropertyValue(); // está retornado null para algunos registros
		}

		return pv;
	}

}
