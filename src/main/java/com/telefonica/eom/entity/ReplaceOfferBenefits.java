package com.telefonica.eom.entity;

import java.io.Serializable;
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
* @FileName: ReplaceOfferBenefits.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla REPLACE_OFFER_BENEFITS. 
* 
*/
@Data
@Entity
@Table(name = "REPLACE_OFFER_BENEFITS", schema = "RE_DATA")
public class ReplaceOfferBenefits implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TAB_REPLA_OFFER_BENEFITS")
    private String id;
    
    @Column(name = "BO_CODE")
    private String boCode;

    @Column(name = "SALABILITY_START_DATE")
    private LocalDate salabilityStartDate;
    
    @Column(name = "SALABILITY_END_DATE")
    private LocalDate salabilityEndDate;
    
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    
    @Column(name = "CUSTOMER_SUB_TYPE")
    private String customerSubType;
    
    @Column(name = "SUBSCRIBER_GROUP_VALUE")
    private String suscriberGroupValue;
    
    @Column(name = "TARGET_PROD_OFFER_CODE")
    private String targetProdOfferCode;
    
    @Column(name = "TARGET_PLAN_BO_CODE")
    private String targetPlanBOCode;
    
    @Column(name = "SOURCE_PROD_OFFER_CODE")
    private String sourceProductOfferCode;
    
    @Column(name = "SOURCE_PLAN_BO_CODE")
    private String sourcePlanBOCode;
    
    @Column(name = "SALE_CHANNEL")
    private String saleChannel;
    
    @Column(name = "DEPARTMENT")
    private String department;
    
    @Column(name = "USER_STORE_BRAND")
    private String userStoreBrand;
    
    @Column(name = "USER_STORE_ID")
    private String userStoreId;

}
