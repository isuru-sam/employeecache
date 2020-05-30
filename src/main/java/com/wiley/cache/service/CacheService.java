package com.wiley.cache.service;

import com.wiley.cache.dto.CachableObject;
import com.wiley.cache.dto.RootObject;

public interface CacheService<T> {
	public void putToCache(CachableObject<? extends String,? extends RootObject> object) ;
	public <T extends RootObject> T getFromCache(String key);
	public String removeFromCache(String key);
}
