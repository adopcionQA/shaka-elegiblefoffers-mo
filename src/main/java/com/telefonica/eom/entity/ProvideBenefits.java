package com.telefonica.eom.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ProvideBenefits.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla PROVIDE_BENEFITS. 
* 
*/
@Data
@Entity
@Table(name = "PROVIDE_BENEFITS", schema = "RE_DATA")
public class ProvideBenefits implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TAB_PROVIDE_BENEFITS")
    private String id;
    
    @Column(name = "BO_CODE")
    private String boCode;

    @Column(name = "SALABILITY_START_DATE")
    private LocalDateTime salabilityStartDate;
    
    @Column(name = "SALABILITY_END_DATE")
    private LocalDateTime salabilityEndDate;
    
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    
    @Column(name = "CUSTOMER_SUB_TYPE")
    private String customerSubType;
    
    @Column(name = "PLAN_GROUP")
    private String planGroup;
    
    @Column(name = "PRODUCT_OFFER_CODE")
    private String productOfferCode;
    
    @Column(name = "PLAN_BO_CODE")
    private String planBoCode;
    
    @Column(name = "SALE_CHANNEL")
    private String saleChannel;
    
    @Column(name = "DEPARTMENT")
    private String department;
    
    @Column(name = "DEVICE_GAMA")
    private String deviceGama;
    
    @Column(name = "DEVICE")
    private String device;
    
    @Column(name = "USER_STORE_BRAND")
    private String userStoreBrand;
    
    @Column(name = "USER_STORE_ID")
    private String userStoreId;
    
    @Column(name = "SUBSCRIBER_GROUP_VALUE")
    private String suscriberGroupValue;

}
