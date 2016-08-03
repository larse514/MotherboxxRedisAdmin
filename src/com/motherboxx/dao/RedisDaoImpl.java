package com.motherboxx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import redis.clients.jedis.Jedis;

import com.motherboxx.client.RedisClient;

@Repository
public class RedisDaoImpl implements RedisDao{

	@Autowired
	RedisClient client;
	
	@Override
	public String getCacheValue(String key) {
		System.out.println("I am here: " + key);
		Jedis jedis = client.getClient();
		System.out.println(jedis);
		return jedis.get(key);
	}

	
}
