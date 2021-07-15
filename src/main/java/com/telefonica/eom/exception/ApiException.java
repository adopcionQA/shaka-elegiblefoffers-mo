package com.telefonica.eom.exception;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-26T23:22:21.907Z")

/**
 * Clase generada por el Swagger.
 */

public class ApiException extends Exception {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int		      code;

    public ApiException(int code, String msg) {
	super(msg);
	this.code = code;
    }
}
