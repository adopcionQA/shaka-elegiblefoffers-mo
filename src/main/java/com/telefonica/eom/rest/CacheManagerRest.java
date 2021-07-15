package com.telefonica.eom.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telefonica.eom.commons.Parameters;

/**
 * 
 * @Author: Jose Linares.
 * @Datecreation: 19 feb. 2020 15:00:00
 * @FileName: CacheManagerRest.java
 * @AuthorCompany: Telefonica
 * @version: 0.1
 * @Description: RestController para eliminar caché.
 */

@RestController
@RequestMapping("/cache")
public class CacheManagerRest {

    @Autowired
    private ObjectMapper objMap;

    @Autowired
    private CacheManager manager;

    @Autowired
    private Parameters parameters;

    @DeleteMapping("/clear/all")
    public ResponseEntity<Object> clearAllCaches(@RequestBody String json) throws IOException {
	if (Boolean.TRUE.equals(this.validateUsrPass(json))) {
	    for (String cacheName : manager.getCacheNames()) {
		clearCacheFromCacheName(cacheName);
	    }
	    return new ResponseEntity<>(HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
    }

    @DeleteMapping("/clear/{cacheName}")
    public ResponseEntity<Object> clearCache(@PathVariable("cacheName") String cacheName, @RequestBody String json) throws IOException {
	if (Boolean.TRUE.equals(this.validateUsrPass(json))) {
	    return Boolean.TRUE.equals(clearCacheFromCacheName(cacheName)) ? new ResponseEntity<>(HttpStatus.OK)
		    : new ResponseEntity<>(HttpStatus.NOT_FOUND);
	} else {
	    return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
    }

    @PostMapping("/names")
    public ResponseEntity<List<String>> getCacheNames(@RequestBody String json) throws IOException {
	if (Boolean.TRUE.equals(this.validateUsrPass(json))) {
	    List<String> cacheNames = new ArrayList<>();
	    for (String cacheName : manager.getCacheNames()) {
		if (Boolean.TRUE.equals(cacheExists(manager.getCache(cacheName)))) {
		    cacheNames.add(cacheName);
		}
	    }
	    return new ResponseEntity<>(cacheNames, HttpStatus.OK);
	} else {
	    return new ResponseEntity<>(HttpStatus.METHOD_NOT_ALLOWED);
	}
    }

    private Boolean clearCacheFromCacheName(final String cacheName) {
	final Cache cache = manager.getCache(cacheName);
	if (cache != null) {
	    cache.clear();
	    return true;
	}
	return false;
    }

    private Boolean cacheExists(final Cache cache) {
	return cache != null;
    }

    private Boolean validateUsrPass(String json) throws IOException {
	JsonNode jsonNode = objMap.readTree(json);
	String user = jsonNode.get("user").textValue();
	String password = jsonNode.get("password").textValue();

	if (parameters.getUser().equals(user) && parameters.getPassword().equals(password)) {
	    return Boolean.TRUE;
	} else {
	    return Boolean.FALSE;
	}
    }

}