package com.telefonica.eom.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ServiceActvtnBenefits.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla SERVICE_ACTVTN_BENEFITS. 
* 
*/
@Data
@Entity
@Table(name = "SERVICE_ACTVTN_BENEFITS", schema = "RE_DATA")
public class ServiceActvtnBenefits {
    
    @Id
    @Column(name = "ID_TAB_SERVICE_ACTVTN_BENEFITS")
    private String id;
    
    @Column(name = "BO_CODE")
    private String boCode;
    
    @Column(name = "BO_SERVICE_ACTIVATED")
    private String boServiceActivated;
    
    @Column(name = "CUSTOMER_SUB_TYPE")
    private String customerSubType;
    
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;

    @Column(name = "DEPARTMENT")
    private String department;
    
    @Column(name = "PLAN_BO_CODE")
    private String planBoCode;
    
    @Column(name = "PLAN_GROUP")
    private String planGroup;
    
    @Column(name = "PRODUCT_OFFER_CODE")
    private String productOfferCode;
    
    @Column(name = "SALABILITY_END_DATE")
    private LocalDate salabilityEndDate;

    @Column(name = "SALABILITY_START_DATE")
    private LocalDate salabilityStartDate;

    @Column(name = "SALE_CHANNEL")
    private String saleChannel;
    
    @Column(name = "SERVICE_ACTIVATED")
    private String serviceActivated;
    
    @Column(name = "SUBSCRIBER_GROUP_VALUE")
    private String suscriberGroupValue;
    
    @Column(name = "USER_STORE_BRAND")
    private String userStoreBrand;
    
    @Column(name = "USER_STORE_ID")
    private String userStoreId;

}
