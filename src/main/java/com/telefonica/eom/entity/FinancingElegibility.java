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
* @FileName: FinancingElegibility.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla FINANCING_ELIGIBILITY. 
* 
*/
@Data
@Entity
@Table(name = "FINANCING_ELIGIBILITY", schema = "RE_DATA")
public class FinancingElegibility {
	
    @Id
    @Column(name = "ID_TAB_FINANELIGIBILITY")
    private String id;
    
    @Column(name = "RISK_LEVEL")
    private String riskLevel 	;
    
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;
    
    @Column(name = "CUSTOMER_SUBTYPE")
    private String customeSubtype;
    
    @Column(name = "FLOW_NAME")
    private String flowName;
    
    @Column(name = "FINANCING_PLAN")
    private String financingPlan;

}
