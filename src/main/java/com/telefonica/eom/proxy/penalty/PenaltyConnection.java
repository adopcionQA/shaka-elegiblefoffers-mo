package com.telefonica.eom.proxy.penalty;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import pe.telefonica.customerordermanagement.orderservices.v1.types.ObjectFactory;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyRequestType;
import pe.telefonica.customerordermanagement.orderservices.v1.types.RetrieveCommitmentPenaltyResponseType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September. 2020
 * @FileName: PenaltyConnection.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los metodos necesarios para conectarse al servicio
 *               soap del detalle de Penalidades.
 * 
 */
@Service
public class PenaltyConnection {

    @Autowired
    @Qualifier("penaltyWS")
    private WebServiceTemplate wsorderServices;

    @SuppressWarnings("unchecked")

    /***
     * Método que envia un request a un servicio soap.
     * 
     * @param url
     *            : Url del servicio soap.
     * @param request
     *            : Request que será enviada al servicio soap.
     * @param metodoRequest
     *            : Método utilizado para enviar el request.
     * @return Response del servicio soap.
     */
    public JAXBElement<RetrieveCommitmentPenaltyResponseType> callWebService(RetrieveCommitmentPenaltyRequestType request) {

	ObjectFactory jAXBElementOfRequest = new ObjectFactory();

	return (JAXBElement<RetrieveCommitmentPenaltyResponseType>) wsorderServices
		.marshalSendAndReceive(jAXBElementOfRequest.createRetrieveCommitmentPenaltyRequest(request));
    }

}
