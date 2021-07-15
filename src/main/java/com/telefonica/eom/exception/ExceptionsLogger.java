package com.telefonica.eom.exception;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;
import com.telefonica.eom.generated.offers.model.ExceptionType;




/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: December 2020
 * @FileName: ExceptionsLogger.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase Service que se encarga de escribir los logs para los
 *               errores customizados.
 */
@Service
public class ExceptionsLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionsLogger.class);

    public void printCustomError(ExceptionType error) {
	StringBuilder log = new StringBuilder();
	log.append("[Code Error]: ");
	log.append(error.getExceptionId());
	log.append(Constant.NEW_LINE);
	log.append("[Exception Message]: ");
	log.append(error.getMoreInfo());
	log.append(Constant.NEW_LINE);
	logError(log.toString(), null);
    }

    private static void logError(String log, Exception e) {
	StringBuilder finalLog = new StringBuilder();
	finalLog.append(getHeaderForLog());
	finalLog.append(log);
	finalLog.append(Constant.SEPARATOR);
	String finallog = finalLog.toString();
	if (e != null) {
	    LOGGER.error(finallog, e);
	} else {
	    LOGGER.error(finallog);
	}
    }

    private static String getHeaderForLog() {
	StringBuilder headerLog = new StringBuilder();
	headerLog.append(Constant.NEW_LINE + Constant.SEPARATOR + Constant.NEW_LINE);
	headerLog.append("[TrackingID]: ");
	headerLog.append(Util.getTracking());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Date]: ");
	headerLog.append(new Date());
	headerLog.append(Constant.NEW_LINE);
	headerLog.append("[Time]: ");
	headerLog.append(Util.getDateFormat(new Date(), Constant.TIME));
	headerLog.append(Constant.NEW_LINE + "" + Constant.NEW_LINE);
	return headerLog.toString();
    }

}
