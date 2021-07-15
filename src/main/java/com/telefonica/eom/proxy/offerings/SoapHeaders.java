package com.telefonica.eom.proxy.offerings;

import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.TransformerException;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapMessage;

import com.telefonica.globalintegration.header.HeaderInType;
import com.telefonica.globalintegration.header.ObjectFactory;

public class SoapHeaders implements WebServiceMessageCallback {

    private HeaderInType headerInType;

    public SoapHeaders(HeaderInType headerInType) {
	this.headerInType = headerInType;
    }

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
	SoapHeader soapHeader = ((SoapMessage) message).getSoapHeader();

	try {
	    JAXBContext context = JAXBContext.newInstance(HeaderInType.class);
	    ObjectFactory headerof = new ObjectFactory();

	    Marshaller marshaller = context.createMarshaller();
	    marshaller.marshal(headerof.createHeaderIn(headerInType), soapHeader.getResult());

	} catch (JAXBException e) {
	    throw new IOException("error while marshalling authentication.");
	}

    }

}
