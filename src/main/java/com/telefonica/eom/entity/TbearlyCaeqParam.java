package com.telefonica.eom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "TBEARLY_CAEQ_PARAM", schema = "RE_DATA")
public class TbearlyCaeqParam implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_TAB_TBEARLY_CAEQ_PARAM")
    private String id;
    
    @Column(name = "GVS")
    private String gvs;
    
    @Column(name = "DAYS_PRIOR_EXP")
    private Long daysPriorExp;
    
    @Column(name = "DOWNGRADE_TOL")
    private Long downgradeTol;

}
