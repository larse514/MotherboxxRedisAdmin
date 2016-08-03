package com.motherboxx.client;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import redis.clients.jedis.Jedis;


@Component
public class RedisClient {
	
	public Jedis getClient() {
		return client;
	}

	private Jedis client;
	
	@PostConstruct	
	public void init(){
		//todo-factor this out
		client = new Jedis("motherboxxcache.br0imq.0001.usw2.cache.amazonaws.com", 6379);
	}
}
