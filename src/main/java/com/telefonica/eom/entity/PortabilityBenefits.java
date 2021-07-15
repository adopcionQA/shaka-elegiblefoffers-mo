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
* @FileName: PortabilityBenefits.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla PORTABILITY_BENEFITS. 
* 
*/
@Data
@Entity
@Table(name = "PORTABILITY_BENEFITS", schema = "RE_DATA")
public class PortabilityBenefits implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "ID_TAB_PORTABILITY_BENEFITS")
    private String id;
    
    @Column(name = "BO_CODE")
    private String boCode;

    @Column(name = "SALABILITY_START_DATE")
    private LocalDateTime salabilityStartDate;
    
    @Column(name = "SALABILITY_END_DATE")
    private LocalDateTime salabilityEndDate;
    
    @Column(name = "CUST_TYPE")
    private String customerType;
    
    @Column(name = "CUST_SUB_TYPE")
    private String customerSubType;
    
    @Column(name = "PLAN_GROUP")
    private String planGroup;
    
    @Column(name = "PLAN_BO_CODE")
    private String planBoCode;
    
    @Column(name = "PROD_TYPE_DONOR")
    private String prodTypeDonor;
    
    @Column(name = "DONOR_OPERATOR")
    private String donorOperator;
    
    @Column(name = "AGE_IN_DONOR")
    private String ageInDonor;
    
    @Column(name = "HAS_DEVICE")
    private String hasDevice;
    
    @Column(name = "SALES_CHANNEL")
    private String salesChannel;
    
    @Column(name = "STORE_ID")
    private String storeId;
    
    @Column(name = "STORE_BRAND")
    private String storeBrand;
    
    @Column(name = "DEVICE")
    private String device;
    
    @Column(name = "DEPARTMENT")
    private String department;

}
