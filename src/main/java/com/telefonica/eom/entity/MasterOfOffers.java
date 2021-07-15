package com.telefonica.eom.entity;

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
* @FileName: MasterOfOffers.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Entity que representa la tabla MASTER_OF_OFFERS. 
* 
*/
@Data
@Entity
@Table(name = "MASTER_OF_OFFERS", schema = "RE_DATA")
public class MasterOfOffers {
    
    @Id
    @Column(name = "ID_TAB_MASTER_OF_OFFERS")
    private String id;
    
    @Column(name = "OFFER_CID")
    private String offerCid;

    @Column(name = "OFFER_CAPTION")
    private String offerCaption;
    
    @Column(name = "NAME_OFFER")
    private String nameOffer;
    
    @Column(name = "OFFER_LAST_VERSION")
    private String offerLastVersion;
    
    @Column(name = "DATE_BEGIN")
    private LocalDateTime dateBegin;
    
    @Column(name = "DATE_END")
    private LocalDateTime dateEnd;
    
    @Column(name = "DESCRIPTION_TEXT")
    private String descriptionText;

}
