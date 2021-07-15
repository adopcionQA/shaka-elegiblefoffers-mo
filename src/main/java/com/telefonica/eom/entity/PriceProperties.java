package com.telefonica.eom.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "PRICE_PROPERTIES", schema = "RE_DATA")
public class PriceProperties implements Serializable {
	
	    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
	    @Column(name = "ID_TAB_PRICE_PROPERTIES")
	    private Integer id;
	    
	    @Column(name = "BILLING_OFFER_CID")
	    private String billingOfferId;
	    
	    @Column(name = "PRICE_ID")
	    private Integer priceId;
	    
	    @Column(name = "NAME_PROP_ABP")
	    private String namePropAbp;
	    
	    @Column(name = "VALUE_ABP")
	    private String valueAbp;
	    
	    @Column(name = "REVENUE_TYPE")
	    private String revenueType;
	    
	    @Column(name = "ITEM_TYPE")
	    private String itemType;	     
	

}
