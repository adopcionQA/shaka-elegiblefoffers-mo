package com.telefonica.eom.enums;

import lombok.Getter;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: NumberEnum.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: NumberEnum . 
* 
*/
public enum NumberEnum {
	
    	THREE(3),
	FOUR(4),
	FIVE(5),
	EIGHT(8);
	
	@Getter
	private int value;
	
	private NumberEnum(int value) {
		this.value = value;
	}

}
