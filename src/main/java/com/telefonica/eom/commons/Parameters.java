package com.telefonica.eom.commons;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import lombok.Getter;

@Getter
@PropertySource("classpath:parameters.properties")
@ConfigurationProperties
@Service
public class Parameters {
    
    @Value(value = "${flush.cache.user}")
    public String user;

    @Value(value = "${flush.cache.password}")
    public String password;
}
