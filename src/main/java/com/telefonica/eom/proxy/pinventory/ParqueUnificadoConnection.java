package com.telefonica.eom.proxy.pinventory;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.telefonica.eom.commons.WSProperties;
import com.telefonica.eom.generated.pinventory.model.ProductInstanceType;

/**
 * 
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September. 2020
 * @FileName: PenaltyConnection.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Representa los metodos necesarios para conectarse al servicio
 *               Rest del parque Unificado.
 * 
 */
@Service
public class ParqueUnificadoConnection {

    @Autowired
    private WSProperties prop;

    @Autowired
    RestTemplate restTemplate;

    private static Logger logger = LogManager.getLogger(ParqueUnificadoConnection.class);

    public List<ProductInstanceType> callRestService(String productPublicId, String productType) {

	try {
	    URI url = UriComponentsBuilder.fromUriString(prop.getUrlProductInventoryService()).queryParam("publicId", productPublicId)
		    .queryParam("type", productType).build().encode().toUri();

	    ResponseEntity<List<ProductInstanceType>> response = restTemplate.exchange(url, HttpMethod.GET, null,
		    new ParameterizedTypeReference<List<ProductInstanceType>>() {
		    });

	    return response.getBody();

	} catch (Exception exception) {
	    logger.info("No information from Product Inventory");
	}

	return Collections.emptyList();
    }

}
