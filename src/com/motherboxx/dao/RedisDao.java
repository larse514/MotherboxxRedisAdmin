package com.motherboxx.dao;

public interface RedisDao {

	public String getCacheValue(String key);
	public String setValue(String key, String value);
}
