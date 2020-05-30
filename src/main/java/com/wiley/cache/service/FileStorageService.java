package com.wiley.cache.service;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.cache.dto.CachableObject;
import com.wiley.cache.dto.ObjectEntry;
import com.wiley.cache.dto.RootObject;

public class FileStorageService implements StorageService {
	@Value("${fileMaxSize}")
	public Integer maxSize;

	@Override
	public void putToCache(Object key, ObjectEntry value) {
		// TODO Auto-generated method stub

	}

	@Override
	public ObjectEntry getFromCache(Object key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getMaxSize() {
		return maxSize;
	}

	@Override
	public void removeFromCache(Object key) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LinkedHashMap<Object, ObjectEntry> getAllEntries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getOldestKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLFUKey() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getLRUKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
