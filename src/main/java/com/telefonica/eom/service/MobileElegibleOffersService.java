package com.telefonica.eom.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.telefonica.eom.business.benefits.interfaces.IReplaceBenefit;
import com.telefonica.eom.business.svas.AdditionalServices;
import com.telefonica.eom.business.svas.SVASFiller;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.enums.ErrorEnum;
import com.telefonica.eom.exception.NotExistingResourceException;
import com.telefonica.eom.exception.NotFoundException;
import com.telefonica.eom.generated.offers.model.OfferingType;
import com.telefonica.eom.generated.offers.model.PaginationInfoType;
import com.telefonica.eom.generated.offers.model.ResponseType;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.eom.proxy.offerings.Offerings;
import com.telefonica.eom.proxy.penalty.Penalty;
import com.telefonica.eom.repository.BillingOfferMasterRepo;
import com.telefonica.eom.repository.OffersPropertiesRepo;
import com.telefonica.eom.repository.PropertyInBillingOfferRepo;
import com.telefonica.eom.repository.ReplaceOfferBenefitsRepo;
import com.telefonica.eom.repository.SvaofferingRepo;
import com.telefonica.globalintegration.services.retrieveofferings.v1.CategoryListType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: MobileElegibleOffersService.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que obtendra el response de acuerdo a Mobile o
 *               SVA.
 */
@Service
public class MobileElegibleOffersService {

	@Autowired
	Offerings offerings;

	@Autowired
	Penalty penalties;

	@Autowired
	ReplaceOfferBenefitsRepo replaceOfferBenefitsRepo;

	@Autowired
	IReplaceBenefit benefits;

	@Autowired
	BillingOfferMasterRepo billingOfferMasterRepo;

	@Autowired
	PropertyInBillingOfferRepo propertyInBillingOfferRepo;

	@Autowired
	AdditionalServices additionalServices;

	@Autowired
	SvaofferingRepo svaofferingRepo;

	@Autowired
	OffersPropertiesRepo offersPropertiesRepo;

	@Autowired
	SVASFiller sVASFiller;

	@Autowired
	ResponseFiller responseFiller;

	/**
	 * Metodo que retorna response de acuerdo a Tipo SVA o Movil
	 * 
	 * @param MobileElegibleOffersRequest
	 * @return ResponseType
	 * @throws NotFoundException
	 */
	public ResponseType getOffers(MobileElegibleOffersRequest meor) throws NotExistingResourceException {

	
		
		ResponseType responseType = new ResponseType();
		List<OfferingType> listOfferType = new ArrayList<>();
		PaginationInfoType pit = new PaginationInfoType();

		if (meor.getProductType().contains(Constant.SVA_STRING) && meor.getProductType().contains(Constant.MOBILE_STRING)) {
			List<OfferingType> listOfferTypeSVA = sVASFiller.getResponse(meor);
			listOfferType.addAll(listOfferTypeSVA);
		} else if (meor.getProductType().contains(Constant.MOBILE_STRING)) {

			RetrieveOfferingsResponseType offeringsResponse = offerings.consult(meor);

			Boolean haveOffering = Boolean.FALSE;

			for (CategoryListType category : offeringsResponse.getCategories()) {

				if (!(category.getOfferings() == null || category.getOfferings().isEmpty())) {
					haveOffering = Boolean.TRUE;
				}
			}

			if (Boolean.TRUE.equals(haveOffering)) {
				List<OfferingType> listOfferTypeAMDOCS = responseFiller.getResponse(offeringsResponse.getCategories(),
						meor);
				listOfferType.addAll(listOfferTypeAMDOCS);
				pit = responseFiller.getPagination(offerings.consult(meor).getCategories(),
						meor.getPaginationInfoPage());
			}

		}

		if (listOfferType.isEmpty()) {
		    throw new NotExistingResourceException(ErrorEnum.SVC1006_TEXT.getValue(), Constant.CODE_404_MSG);
		}

		responseType.offerings(listOfferType);
		responseType.setPaginationInfo(pit);

		return responseType;
	}

}
