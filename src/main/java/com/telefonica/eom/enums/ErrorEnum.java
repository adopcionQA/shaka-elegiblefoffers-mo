package com.telefonica.eom.enums;

import lombok.Getter;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: ErrorEnum.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Contiene codigos, formaters y descripciones de errores que se
 *               retornan como respuesta en caso de error en la ejecucion del
 *               programa
 * 
 */
public enum ErrorEnum {

    SVC0001_ID("SVC0001"), 
    SVC0001_TEXT("Generic Client Error: %s"), 
    SVC0001_INFO("API Generic wildcard fault response"), 
    SVC0001_MESSAGE("Generic Client Error"),

    SVC1006_ID("SVC1006"), 
    SVC1006_TEXT("Resource %s does not exist"), 
    SVC1006_MESSAGE("Not existing Resource Id"),

    SVC1007_ID("SVC1007"), 
    SVC1007_TEXT("Conflict: %s"), 
    SVC1007_MESSAGE("Not existing Resource Id"),

    SVC1000_ID("SVC1000"), 
    SVC1000_TEXT("Generic Server Error: %s"), 
    SVC1000_INFO("There was a problem in the Service Providers network that prevented to carry out the request"), 
    SVC1000_MESSAGE("Generic Server Fault");

    @Getter
    private String value;

    private ErrorEnum(String value) {
	this.value = value;
    }

}
