package com.telefonica.eom.config;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
*
* @Author: Freddy Ipanaque Castillo
* @Datecreation: September 2020
* @FileName: AspectConfig.java
* @AuthorCompany: Telefonica
* @version: 0.1
* @Description: Clase de configuracion para el ASPECT.
*/
@Aspect
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class AspectConfig {

    @Pointcut("execution(public * com.telefonica.eom.service..*.*(..))")
    public void logServiceMethod() {
	//just to set the Pointcut in service package
    }
    
    @Pointcut("execution(public * com.telefonica.eom.business..*.*(..))")
    public void logBusinessMethod() {
	//just to set the Pointcut in business package
    }

}
