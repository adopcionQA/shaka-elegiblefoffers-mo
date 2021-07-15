package com.telefonica.eom.enums;

import lombok.Getter;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: ADataEnum.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: ADataEnum . 
* 
*/
public enum ADataEnum {
	
	IMAGE("image"),
	BANNER("banner"),
	DISPLAY_NAME("banner"),
	RELATION_ID("relationId"),
	ID_ASSIGNED_ITEM("relationId"),
	PARENT_CATALOG_ITEM_ID("parentCatalogItemID"),
	PARENT_CATALOG_ITEM_NAME("parentCatalogItemName"),
	PARENT_CURRENT_STATUS("parentCurrentStatus"),
	PARENT_ASSIGNED_ID("parentAssignedID"),
	TOP_RECOMENDED("topRecommended"),
	PRODUCT_TYPE("productType"),
	COMPATIBLE_WITH_DEVICE("compatibleWithDevice"),
	MIN_NUM_OF_SUSCRIBERS("minNumOfSubscribers"),
	NUM_OF_SUSCRIBERS("numOfSubscribers"),
	SHARED_PLAN("sharedPlan"),
	APPLY_FINANCING("aplicaFinanciamiento");
	
	@Getter
	private String value;
	
	private ADataEnum(String value){
		this.value = value;
	}
	
}
