package com.wiley.cache.service;

import java.util.LinkedHashMap;

import com.wiley.cache.dto.ObjectEntry;

public interface StorageService {
	public void putToCache(Object key, ObjectEntry value);

	public ObjectEntry getFromCache(Object key);

	public void removeFromCache(Object key);

	public Integer count();

	public Integer getMaxSize();

	public LinkedHashMap<Object, ObjectEntry> getAllEntries();

	public Object getOldestKey();

	public Object getLFUKey();

	public Object getLRUKey();
}
