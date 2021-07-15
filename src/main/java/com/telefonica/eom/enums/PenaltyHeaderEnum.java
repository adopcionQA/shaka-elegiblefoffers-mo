package com.telefonica.eom.enums;

import lombok.Getter;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: PenaltyHeaderEnum.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: PenaltyHeaderEnum . 
* 
*/
@Getter
public enum PenaltyHeaderEnum {

    RETRIEVEDEVICE_USERLOGIN("DAAS"), 
    RETRIEVEDEVICE_SETIPADDRESS("127.0.0.1"), 
    RETRIEVEDEVICE_SERVICECHANNEL("DAAS"),
    RETRIEVEDEVICE_APPLICATION("DAAS"),
    RETRIEVEDEVICE_VERSION("1.0"),
    RETRIEVEDEVICE_SERVICENAME("CustomerOrderManagement.retrieveCommitmentPenalty");

    private String value;

    private PenaltyHeaderEnum(String value) {
	this.value = value;
    }

}
