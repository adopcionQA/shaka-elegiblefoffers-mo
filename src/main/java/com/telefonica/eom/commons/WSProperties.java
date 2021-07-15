package com.telefonica.eom.commons;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import lombok.Data;

@Service
@Data
@ConfigurationProperties(prefix = "ws")
public class WSProperties {

    private String  urlProductInventoryService;
    private String  urlPenaltyService;
    private String  urlOfferingsService;
    private Integer connectiontimeout;
    private Integer readtimeout;

}
