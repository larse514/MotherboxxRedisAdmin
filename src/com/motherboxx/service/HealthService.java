package com.motherboxx.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motherboxx.client.RedisClient;

@Service
public class HealthService {

	@Autowired
	RedisClient client;
	
	public String healthCheck(){
		return client.getClient().ping();
	}
}
