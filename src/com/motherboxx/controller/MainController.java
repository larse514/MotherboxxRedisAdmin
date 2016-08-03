package com.motherboxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motherboxx.constant.Constant;
import com.motherboxx.service.HealthService;
import com.motherboxx.service.RedisService;
 
/*
 * author: Crunchify.com
 * 
 */
 
@RestController
@RequestMapping("/")
public class MainController {
 
	@Autowired
	RedisService service;
	@Autowired
	HealthService health;
	@RequestMapping(value = "/getValue/{key}", produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<String> getValue(@PathVariable("key") String key) {
		//get cache value
		String value = service.getCacheValue(key);
		//if key not found is return, return 404
    	if(value == Constant.KEY_NOT_FOUND){
    		return new ResponseEntity<>(value, HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(value, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/healthCheck", produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<String> getValue() {
    	
        return new ResponseEntity<>(health.healthCheck(), HttpStatus.OK);
    }
}