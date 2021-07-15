package com.telefonica.eom.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: NotExistingResourceException.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Error customizado que se invoca cuando no se obtiene
 *               información suficiente de alguna fuente que consume el motor
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class NotExistingResourceException extends RuntimeException {

    private static final long serialVersionUID = -1717159087127156150L;
    private final String      message;
    private final String      info;

    public NotExistingResourceException(String message, String info) {
	this.message = message;
	this.info = info;
    }

    public NotExistingResourceException(Throwable cause, String message, String info) {
	super(cause);
	this.message = message;
	this.info = info;
    }

}
