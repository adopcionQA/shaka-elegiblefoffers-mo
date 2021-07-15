package com.telefonica.eom.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: GenericClientException.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Error customizado que representa el Generic Client Error
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GenericClientException extends RuntimeException {

    private static final long serialVersionUID = -7848685364529738345L;
    private final String      message;

    public GenericClientException(String message) {
	this.message = message;
    }

    public GenericClientException(Throwable cause, String message) {
	super(cause);
	this.message = message;
    }

}
