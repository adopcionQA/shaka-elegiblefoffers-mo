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
* @FileName: FinancingCode.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla FINANCING_CODE. 
* 
*/
@Data
@Entity
@Table(name = "FINANCING_CODE", schema = "RE_DATA")
public class FinancingCode {

    @Id
    @Column(name = "ID_TAB_FINANCINGCODE")
    private String id;
    
    @Column(name = "BANK_CODE")
    private String bankCode;
    
    @Column(name = "BANK_NAME")
    private String bankName;
    
    @Column(name = "FINANCIAL_PLAN_CODE")
    private String financialPlanCode;
    
    @Column(name = "FINANCIAL_PLAN_DESCRIPTION")
    private String financialPlanDescription;
    
    @Column(name = "APPLICATION_ID")
    private String applicationId;
    
    @Column(name = "IS_CORPORATE")
    private String isCorporate;
    
    @Column(name = "HAS_FWA")
    private String hasFwa;
    
    @Column(name = "SUB_TYPE")
    private String subType;
    
    @Column(name = "FINANCING_ELIGIBILITY_IND")
    private String fiancingElegibilityInd;
    
}
