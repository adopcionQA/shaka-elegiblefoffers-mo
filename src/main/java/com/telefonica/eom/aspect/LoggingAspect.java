package com.telefonica.eom.aspect;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.util.StopWatch;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.eom.commons.Constant;
import com.telefonica.eom.commons.Util;

/**
 *
 * @Author: Freddy Ipanaque Castillo
 * @Datecreation: September 2020
 * @FileName: LogginAspect.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: Clase LOGGER haciendo uso de AOP.
 */
@Configuration
@Aspect
public class LoggingAspect {

	@Autowired
	private Environment environment;

	@Autowired
	private ObjectMapper objMapper;

	private static Logger logger = LogManager.getLogger(LoggingAspect.class);

	/**
	 * Metodo que genera logs de las clase Business
	 * 
	 * @param ProceedingJoinPoint
	 * @return Object
	 */
	@Around("com.telefonica.eom.config.AspectConfig.logBusinessMethod()")
	public Object logBeforeProxyMethod(ProceedingJoinPoint joinPoint) throws Throwable {
		StringBuilder log = new StringBuilder();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		log.append(Constant.CLASS_LOG_LABEL);
		log.append(className);
		log.append(Constant.NEW_LINE);
		log.append(Constant.METHOD_LOG_LABEL);
		log.append(methodName);
		log.append(Constant.PARAMETERS_LOG_LABEL);
		log.append(Constant.NEW_LINE);
		log.append(Constant.INPUT_PARAMETERS_LABEL);
		log.append(Constant.NEW_LINE);
		Object[] args = joinPoint.getArgs();
		String[] argNames = methodSignature.getParameterNames();
		Map<String, Object> map = zipToMap(Arrays.asList(argNames), Arrays.asList(args));

		map.entrySet().forEach(entry -> {
			String type = entry.getKey() == null ? "Null" : entry.getKey().getClass().getSimpleName();
			try {
				log.append(String.format("-[%s] %s = %s ".concat(Constant.NEW_LINE), type, entry.getValue(),
						entry.getKey() == null ? "Null" : objMapper.writeValueAsString(entry.getKey())));
			} catch (JsonProcessingException e) {
				log.append(Constant.PARSE_JSON_RESPONSE).append(Constant.NEW_LINE);
			}
		});

		StopWatch watch = new StopWatch();
		try {
			if (environment.acceptsProfiles(Constant.DEV_ENVIRONMENT)) {
				watch.start();
			}
			Object result = joinPoint.proceed();
			log.append(Constant.OUTPUT_LABEL);
			log.append(Constant.NEW_LINE);

			try {
				log.append(String.format("-[%s] = [%s]".concat(Constant.NEW_LINE), "RESULT",
						objMapper.writeValueAsString(result)));
			} catch (Exception e) {
				log.append(Constant.PARSE_JSON_RESPONSE);
				log.append(Constant.NEW_LINE);
			}

			return result;
		} catch (Exception e) {
			log.append(Constant.NEW_LINE);
			log.append(Constant.EXCEPTION_WAS_THROWN);
			log.append("[" + e.getMessage() + "]");
			log.append(Constant.NEW_LINE);
			throw e;
		} finally {
			if (environment.acceptsProfiles(Constant.DEV_ENVIRONMENT)) {
				watch.stop();
				logInfo(log.toString(), watch);
			} else {
				logInfo(log.toString());
			}
		}
	}

	/**
	 * Metodo que genera logs de las clase Service
	 * 
	 * @param JoinPoint
	 * @return
	 */
	@Before("com.telefonica.eom.config.AspectConfig.logServiceMethod()")
	public void logBeforeWebFactoryMethod(JoinPoint joinPoint) throws Throwable {
		StringBuilder log = new StringBuilder();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String methodName = joinPoint.getSignature().getName();
		String className = joinPoint.getTarget().getClass().getName();
		log.append(Constant.CLASS_LOG_LABEL);
		log.append(className);
		log.append(Constant.NEW_LINE);
		log.append(Constant.METHOD_LOG_LABEL);
		log.append(methodName);
		log.append(Constant.PARAMETERS_LOG_LABEL);
		log.append(Constant.NEW_LINE);
		log.append(Constant.INPUT_PARAMETERS_LABEL);
		log.append(Constant.NEW_LINE);

		Object[] args = joinPoint.getArgs();
		String[] argNames = methodSignature.getParameterNames();
		Map<String, Object> map = zipToMap(Arrays.asList(argNames), Arrays.asList(args));

		map.entrySet().forEach(entry -> {
			String type = entry.getKey() == null ? "Null" : entry.getKey().getClass().getSimpleName();
			try {
				log.append(String.format("-[%s] %s = %s ".concat(Constant.NEW_LINE), type, entry.getValue(),
						entry.getKey() == null ? "Null" : objMapper.writeValueAsString(entry.getKey())));
			} catch (JsonProcessingException e) {
				log.append(Constant.PARSE_JSON_RESPONSE).append(Constant.NEW_LINE);
			}
		});
		logInfo(log.toString());
	}

	/**
	 * Metodo utilitario
	 * 
	 * @param String
	 * @return
	 */
	private static void logInfo(String log) {
		StringBuilder finalLog = new StringBuilder();
		finalLog.append(getHeaderForLog()).append(log).append(getFooterLog());
		logger.info(finalLog.toString());
	}

	/**
	 * Metodo que genera la cabecera del Log
	 *
	 * @param
	 * @return String
	 */
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
		headerLog.append(Util.getDateTimeFormatter());
		headerLog.append(Constant.NEW_LINE + "" + Constant.NEW_LINE);
		return headerLog.toString();
	}

	/**
	 * Metodo que genera el footer del Log
	 *
	 * @param
	 * @return String
	 */
	private static String getFooterLog() {
		return Constant.SEPARATOR;
	}

	/**
	 * Metodo utilitario
	 *
	 * @param String,StopWatch
	 * @return
	 */
	private static void logInfo(String log, StopWatch watch) {
		StringBuilder finalLog = new StringBuilder();
		finalLog.append(getHeaderForLog(watch)).append(log).append(getFooterLog());
		logger.info(finalLog.toString());
	}

	/**
	 * Metodo que genera la cabecera del Log
	 *
	 * @param StopWatch
	 * @return String
	 */
	private static String getHeaderForLog(StopWatch watch) {
		StringBuilder headerLog = new StringBuilder();
		headerLog.append(Constant.NEW_LINE + Constant.SEPARATOR + Constant.NEW_LINE);
		headerLog.append("[TrackingID]: ");
		headerLog.append(Util.getTracking());
		headerLog.append(Constant.NEW_LINE);
		headerLog.append("[Excecution Date]: ");
		headerLog.append(new Date());
		headerLog.append(Constant.NEW_LINE);
		headerLog.append("[Excecution Time]: ");
		headerLog.append(Util.getDateTimeFormatter());
		headerLog.append(Constant.NEW_LINE);
		headerLog.append("[Measure Method Time]: ");
		headerLog.append(watch.getTotalTimeMillis());
		headerLog.append(Constant.NEW_LINE + "" + Constant.NEW_LINE);
		return headerLog.toString();
	}

	/**
	 * Metodo utilitario
	 *
	 * @param List<K>,List<V>
	 * @return Map<K, V>
	 */
	public static <K, V> Map<K, V> zipToMap(List<K> keys, List<V> values) {
		return IntStream.range(0, keys.size()).collect(HashMap::new, (m, i) -> m.put(keys.get(i), values.get(i)),
				Map::putAll);
	}

}
