package com.telefonica.eom.exception;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2019-08-26T23:22:21.907Z")

/**
 * Clase generada por el Swagger.
 */

public class NotFoundException extends ApiException {
    private int code;

    public NotFoundException(int code, String msg) {
	super(code, msg);
	this.code = code;
    }
}
