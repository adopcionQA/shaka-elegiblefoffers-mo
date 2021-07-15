package com.telefonica.eom.exception;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.telefonica.eom.commons.Util;
import com.telefonica.eom.enums.ErrorEnum;
import com.telefonica.eom.generated.offers.model.ExceptionType;





/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: RestExceptionHandler.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase que intercepta todos los posibles errores lanzados
 *               durante la ejecución de motor.
 */
@RestControllerAdvice
public class RestExceptionHandler {

    @Autowired
    private ExceptionsLogger exLogger;

    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

    @ExceptionHandler(GenericClientException.class)
    public final ResponseEntity<Object> handleGenericClientException(GenericClientException ex) {

	ExceptionType error = new ExceptionType();
	error.setExceptionId(ErrorEnum.SVC0001_ID.getValue());
	error.setExceptionText(this.format(ErrorEnum.SVC0001_TEXT.getValue(), ex.getMessage()));
	error.setMoreInfo(ErrorEnum.SVC0001_INFO.getValue());
	error.setUserMessage(ErrorEnum.SVC0001_MESSAGE.getValue());

	exLogger.printCustomError(error);

	return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotExistingResourceException.class)
    public final ResponseEntity<Object> handleNotExistingResourceException(NotExistingResourceException ex) {

	ExceptionType error = new ExceptionType();
	error.setExceptionId(ErrorEnum.SVC1006_ID.getValue());
	error.setExceptionText(this.format(ErrorEnum.SVC1006_TEXT.getValue(), ex.getMessage()));
	error.setMoreInfo(ex.getInfo());
	error.setUserMessage(ErrorEnum.SVC1006_MESSAGE.getValue());

	exLogger.printCustomError(error);

	return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotExistingFOException.class)
    public final ResponseEntity<Object> handleNotExistingFOException(NotExistingFOException ex) {

	ExceptionType error = new ExceptionType();
	error.setExceptionId(ErrorEnum.SVC1007_ID.getValue());
	error.setExceptionText(this.format(ErrorEnum.SVC1007_TEXT.getValue(), ex.getMessage()));
	error.setMoreInfo(ex.getInfo());
	error.setUserMessage(ErrorEnum.SVC1007_MESSAGE.getValue());

	exLogger.printCustomError(error);

	return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex) {

	ExceptionType error = new ExceptionType();
	error.setExceptionId(ErrorEnum.SVC1000_ID.getValue());
	error.setExceptionText(this.format(ErrorEnum.SVC1000_TEXT.getValue(), ex.getMessage()));
	error.setMoreInfo(ErrorEnum.SVC1000_INFO.getValue());
	error.setUserMessage(ErrorEnum.SVC1000_MESSAGE.getValue());

	LOGGER.error("TrackingId: {}", Util.getTracking());
	LOGGER.error(ExceptionUtils.getStackTrace(ex));

	return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    private String format(String format, String arg) {
	return String.format(format, arg);
    }

}
