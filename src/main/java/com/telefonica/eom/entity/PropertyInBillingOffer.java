package com.telefonica.eom.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: PropertyInBillingOffer.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla PROPERTY_IN_BILLING_OFFER. 
* 
*/
@Data
@Entity
@Table(name = "PROPERTY_IN_BILLING_OFFER", schema = "RE_DATA")
public class PropertyInBillingOffer {
	
    @Id
    @Column(name = "ID_TAB_PROPER_IN_BO")
    private String id;
    
    @Column(name = "CID_BO")
    private String cidBo;
    
    @Column(name = "CAPTION_BO")
    private String captionBo;
    
    @Column(name = "VERSION_BO")
    private long versionBo;
    
    @Column(name = "PROPERTY_NAME")
    private String propertyName;
    
    @Column(name = "PROPERTY_VALUE")
    private String propertyValue;
    
    @Column(name = "IS_PROMOTE")
    private String isPromote;
    
    @Column(name = "DURATION_VALUE")
    private String durationValue;
    
    @Column(name = "UNIT")
    private String unit;
    
    @Column(name = "PRICE_PLAN_TYPE")
    private String pricePlanType;

}
