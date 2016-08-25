package com.motherboxx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.motherboxx.constant.Constant;
import com.motherboxx.constant.RedisResponseConstant;
import com.motherboxx.dto.SetValueDto;
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
		String value = service.getCacheValue(key);//get cache value
		//if key not found is return, return 404
    	if(value == Constant.KEY_NOT_FOUND){
    		return new ResponseEntity<>(value, HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(value, HttpStatus.OK);
    }

	@RequestMapping(value = "/setValue", produces=MediaType.APPLICATION_JSON_VALUE,
			consumes=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
    public ResponseEntity<String> setValue(@RequestBody SetValueDto dto) {
		//get key and value
		String key = dto.getKey();
		String value = dto.getValue();
		//call method
		boolean result = service.setValue(key, value);
		
		//if key not found is return, return 404
    	if(result){
    		return new ResponseEntity<>(RedisResponseConstant.OK, HttpStatus.NOT_FOUND);
    	}
        return new ResponseEntity<>(RedisResponseConstant.FAILED_TO_SET, HttpStatus.OK);
    }
	
	@RequestMapping(value = "/healthCheck", produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<String> getValue() {
    	
        return new ResponseEntity<>(health.healthCheck(), HttpStatus.OK);
    }
	
	// return number of keys in database
	@RequestMapping(value = "/itemCheck", produces="application/json", method = RequestMethod.GET)
    public ResponseEntity<String> getCount(){
		String count = service.getCountTotal();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }


}