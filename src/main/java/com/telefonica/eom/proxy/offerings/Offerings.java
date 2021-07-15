package com.telefonica.eom.proxy.offerings;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.telefonica.eom.enums.OfferingHeaderEnum;
import com.telefonica.eom.pojo.MobileElegibleOffersRequest;
import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.ProductTypeEnumType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsRequestType;
import com.telefonica.globalintegration.services.retrieveofferings.v1.RetrieveOfferingsResponseType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: Offerings.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los métodos necesarios para consumir el servicio
 *               Amdocs.
 */
@Service
public class Offerings {

    @Autowired
    OfferingsConnection offeringsConnection;

    @Autowired
    OfferingsRequestParamsFill offeringsRequestParamsFill;

    /**
     * Metodo que invoca al servicio retrieveOfferings de AMDOCS.
     * 
     * @param MobileElegibleOffersRequest
     * @return RetrieveOfferingsResponseType
     */
	public RetrieveOfferingsResponseType consult(MobileElegibleOffersRequest meor) {

	RetrieveOfferingsRequestType rort = new RetrieveOfferingsRequestType();
	
	rort.setCustomerId(new BigDecimal(meor.getCustomerId()));
	rort.getProductType().add(ProductTypeEnumType.MOBILE);
	rort.setCategory(offeringsRequestParamsFill.getCategory(meor));
	rort.setChannelId(meor.getChannelId());
	if (meor.getProductId() != null) {
	    rort.setProductId(meor.getProductId());
	}
	if (meor.getProductOfferingCatalogId() != null) {
		String[] test = meor.getProductOfferingCatalogId().split(",");
	    rort.getProductOfferingCatalogId().addAll(Arrays.asList(test));
	}
	if (meor.getProductOrderId() != null) {
	    rort.setProductOrderId(meor.getProductOrderId());
	}
	if (meor.getPlanId() != null) {
	    rort.setCatalogID(meor.getPlanId());
	}
	rort.setFilterInfo(offeringsRequestParamsFill.getFilterInfo(meor));

	
	HeaderInType headerInType = new HeaderInType();
	Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	
	headerInType.setCountry(OfferingHeaderEnum.COUNTRY.getValue());
	headerInType.setLang(OfferingHeaderEnum.LANG.getValue());
	headerInType.setEntity(OfferingHeaderEnum.ENTITY.getValue());
	headerInType.setSystem(OfferingHeaderEnum.SYSTEM.getValue());
	headerInType.setSubsystem(OfferingHeaderEnum.SUBSYSTEM.getValue());
	headerInType.setOriginator(OfferingHeaderEnum.ORIGINATOR.getValue());
	headerInType.setUserId(OfferingHeaderEnum.USERID.getValue());
	headerInType.setOperation(OfferingHeaderEnum.OPERATION.getValue());
	headerInType.setDestination(OfferingHeaderEnum.DESTINATION.getValue());
	headerInType.setExecId(OfferingHeaderEnum.EXECID.getValue());
	headerInType.setTimestamp(timestamp.toInstant().toString());


	JAXBElement<RetrieveOfferingsResponseType> response = offeringsConnection
		.callWebService(rort, headerInType);

	return response.getValue();
    }

}
