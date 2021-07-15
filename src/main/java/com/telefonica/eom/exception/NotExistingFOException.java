package com.telefonica.eom.exception;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: NotExistingFOException.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Error customizado que se invoca cuando no se obtiene respuesta
 *               de ordenes en vuelo
 */
public class NotExistingFOException extends NotExistingResourceException {

    private static final long serialVersionUID = -8233543716329218379L;

    public NotExistingFOException(String message, String info) {
	super(message, info);
    }

    public NotExistingFOException(Throwable cause, String message, String info) {
	super(cause, message, info);
    }

}
