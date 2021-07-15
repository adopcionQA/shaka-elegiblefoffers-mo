package com.telefonica.eom.enums;

import lombok.Getter;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: PropertyValueEnum.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: PropertyValueEnum . 
* 
*/
public enum PropertyValueEnum {
    
    RETENTION("Retention"),
    LOB_TYPE("LOB Type"),
    PLAN_GROUP("Plan Group");
    
    @Getter
    String value;
    
    private PropertyValueEnum(String value) {
	this.value = value;
    }

}
