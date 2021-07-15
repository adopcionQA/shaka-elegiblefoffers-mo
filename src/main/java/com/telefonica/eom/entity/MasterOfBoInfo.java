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
* @FileName: MasterOfBoInfo.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla MASTER_OF_BO_INFO. 
* 
*/
@Data
@Entity
@Table(name = "MASTER_OF_BO_INFO", schema = "RE_DATA")
public class MasterOfBoInfo {
    
    @Id
    @Column(name = "ID_TAB_MASTER_OF_BO_INFO")
    private String id;
    
    @Column(name = "CID_BO")
    private String cidBo;
    
    @Column(name = "BO_INFO_NAME")
    private String boInfoName;
    
    @Column(name = "BO_INFO_VALUE")
    private String boInfoValue;    

}
