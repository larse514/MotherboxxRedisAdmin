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
		Jedis jedis = client.getClient();
		return jedis.get(key);
	}

	@Override
	public String setValue(String key, String value) {
		Jedis jedis = client.getClient();
		return jedis.set(key, value);
	}
	
	
}
