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
* @FileName: Svaoffering.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla SVAOFFERING. 
* 
*/
@Data
@Entity
@Table(name = "SVAOFFERING", schema = "RE_DATA")
public class Svaoffering implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "ID_TAB_SVAOFFERING")
    private String id;
    
    @Column(name = "LOB_TYPE")
    private String lobType;
    
    @Column(name = "TIPO_OPERATION")
    private String tipoOperation;
    
    @Column(name = "FLAG_RETENCION")
    private String flagRetention;
    
    @Column(name = "FECHA_INICIO")
    private LocalDate fechaInicio;
    
    @Column(name = "FECHA_FIN")
    private LocalDate fechaFin;
    
    @Column(name = "IDCOMPONENTE")
    private String idComponente;

}
