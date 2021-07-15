package com.telefonica.eom.proxy.penalty;

import javax.xml.bind.JAXBElement;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Util;
import com.telefonica.eom.enums.PenaltyHeaderEnum;

import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyRequestDataType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyResponseType;
import pe.telefonica.tefrequestheader.v1.TefHeaderReqType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: Penalty.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los métodos necesarios para consumir el servicio
 *               Amdocs.
 */
@Service
public class Penalty {

	@Autowired
	PenaltyConnection penaltiesConnection;

	/**
	 * Método que se encarga de consultar el servicio Amdocs.
	 * 
	 * @param publicId : Identificador público de un producto.
	 * @return Response que retorna el servicio de Amdocs.
	 * @throws DatatypeConfigurationException
	 */
	public RetrieveCommitmentPenaltyResponseType consult(String publicId) throws DatatypeConfigurationException {
		RetrieveCommitmentPenaltyRequestType request = new RetrieveCommitmentPenaltyRequestType();
		RetrieveCommitmentPenaltyRequestDataType retrieveCommitmentPenaltyRequestDataType = new RetrieveCommitmentPenaltyRequestDataType();

		TefHeaderReqType tefHeaderReqType = new TefHeaderReqType();
		retrieveCommitmentPenaltyRequestDataType.setMSISDN(publicId);

		tefHeaderReqType.setUserLogin(PenaltyHeaderEnum.RETRIEVEDEVICE_USERLOGIN.getValue());
		tefHeaderReqType.setServiceChannel(PenaltyHeaderEnum.RETRIEVEDEVICE_SERVICECHANNEL.getValue());
		tefHeaderReqType.setApplication(PenaltyHeaderEnum.RETRIEVEDEVICE_APPLICATION.getValue());
		tefHeaderReqType.setIpAddress(PenaltyHeaderEnum.RETRIEVEDEVICE_SETIPADDRESS.getValue());
		tefHeaderReqType
				.setTransactionTimestamp(DatatypeFactory.newInstance().newXMLGregorianCalendar(Util.getGCalendar()));
		tefHeaderReqType.setServiceName(PenaltyHeaderEnum.RETRIEVEDEVICE_SERVICENAME.getValue());
		tefHeaderReqType.setVersion(PenaltyHeaderEnum.RETRIEVEDEVICE_VERSION.getValue());

		request.setRetrieveCommitmentPenaltyRequestData(retrieveCommitmentPenaltyRequestDataType);
		request.setTefHeaderReq(tefHeaderReqType);

		JAXBElement<RetrieveCommitmentPenaltyResponseType> response = penaltiesConnection
				.callWebService(request);

		return response.getValue();
	}
}
