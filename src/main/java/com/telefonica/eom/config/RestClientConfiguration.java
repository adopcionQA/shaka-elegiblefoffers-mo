package com.telefonica.eom.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: RestClientConfiguration.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase de configuracion para el cliente REST.
 */
@Configuration
public class RestClientConfiguration {

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

}
