package com.telefonica.eom.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.transport.WebServiceMessageSender;
import org.springframework.ws.transport.http.HttpComponentsMessageSender;

import com.telefonica.eom.commons.WSProperties;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: SoapClientConfig.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase de configuracion para el cliente SOAP.
 */
@Configuration
public class SoapClientConfig {

	@Autowired
	private WSProperties prop;

	/**
	 * Metodo que configura Jaxb2Marshaller.
	 * 
	 * @param
	 * @return Jaxb2Marshaller
	 */
	@Bean
	public Jaxb2Marshaller marshaller() {
		Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
		marshaller.setContextPaths("pe.telefonica.customerordermanagement.orderservices.v1.types",
				"pe.telefonica.teferror.v1", "pe.telefonica.tefrequestheader.v1", "pe.telefonica.tefresponseheader.v1",
				"com.telefonica.globalintegration.fault", "com.telefonica.globalintegration.header",
				"com.telefonica.globalintegration.services.retrieveofferings.v1");
		return marshaller;
	}

	/**
	 * Metodo que configura la invocacion al servio de Penalty.
	 * 
	 * @param
	 * @return WebServiceTemplate
	 */
	@Bean(name = "penaltyWS")
	public WebServiceTemplate penaltyConfigWs() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(marshaller());
		webServiceTemplate.setUnmarshaller(marshaller());
		webServiceTemplate.setDefaultUri(prop.getUrlPenaltyService());
		webServiceTemplate.setMessageSender(wsMessageSender());
		return webServiceTemplate;
	}

	/**
	 * Metodo que configura la invocacion al servio de Offerings.
	 * 
	 * @param
	 * @return WebServiceTemplate
	 */
	@Bean(name = "offeringsWS")
	public WebServiceTemplate offeringsConfigWs() {
		WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
		webServiceTemplate.setMarshaller(marshaller());
		webServiceTemplate.setUnmarshaller(marshaller());
		webServiceTemplate.setDefaultUri(prop.getUrlOfferingsService());
		webServiceTemplate.setMessageSender(wsMessageSender());
		return webServiceTemplate;
	}

	/**
	 * Metodo que configura los tiempos de respuesta.
	 * 
	 * @param
	 * @return WebServiceMessageSender
	 */
	@Bean
	public WebServiceMessageSender wsMessageSender() {
		HttpComponentsMessageSender sender = new HttpComponentsMessageSender();
		sender.setConnectionTimeout(prop.getConnectiontimeout());
		sender.setReadTimeout(prop.getReadtimeout());
		return sender;
	}

}
