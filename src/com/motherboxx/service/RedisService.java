package com.motherboxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motherboxx.constant.Constant;
import com.motherboxx.dao.RedisDao;
import com.motherboxx.hash.HashService;

@Service
public class RedisService {

	@Autowired
	RedisDao dao;
	@Autowired
	HashService hash;
	// added getCountTotal 8/24/2016
	public Integer getCountTotal(){
		Integer count = 10;
		return count;
	}
	
	public String getCacheValue(String key){
		//we need to hash each value since that is how the cache stores the values
		String hashValue = hash.hashValue(key);
		//now do the lookup on the cache
		String response = dao.getCacheValue(hashValue);
		//if we get null, then return key not found
		if(response == null){
			return Constant.KEY_NOT_FOUND;
		}
		return response;
	}
	
	public boolean setValue(String key, String value){
		//hash the key
		String hashKey = hash.hashValue(key);
		//now attempt to set it
		//Response OK-Good
		//Response null-Failed
		String response = dao.setValue(hashKey, value);
		if(response==null){
			return false;
		}
		return true;
		
	}
	
}
