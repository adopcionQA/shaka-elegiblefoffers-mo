package com.telefonica.eom.enums;

import lombok.Getter;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: OfferingHeaderEnum.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: OfferingHeaderEnum . 
* 
*/
public enum OfferingHeaderEnum {
	
	COUNTRY("PE"),
	LANG("es"),
	ENTITY("TEF"),
	SYSTEM("FE"),
	SUBSYSTEM("FE"),
	ORIGINATOR("PE:TEF:FE:FE"),
	SENDER("FE"),
	USERID("te999999"),
	WSID("te1111.xxx.xxxxxx"),
    	WSIP("10.11.11.11"),
	OPERATION("retrieveOfferings"),
	DESTINATION("PE:TEM:DOX:MCS"),
	PID("550e8400-e29b-41d4-a716-446655440011"),
	EXECID("550e8400-e29b-41d4-a716-446655440005"),
	MSGID("550e8400-e29b-41d4-a716-446655440030"),
	TIMESTAMP("2018-04-03T09:30:47.233+01:00"),
	MSGTYPE("REQUEST");

	@Getter
	private String value;

	private OfferingHeaderEnum(String value) {
		this.value = value;
	}

}
