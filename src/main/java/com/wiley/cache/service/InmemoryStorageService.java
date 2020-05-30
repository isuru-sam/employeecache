package com.wiley.cache.service;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;

import com.wiley.cache.dto.ObjectEntry;

public class InmemoryStorageService implements StorageService {
	@Value("${memoryMaxSize}")
	public Integer maxSize;

	@SuppressWarnings("serial")
	final LinkedHashMap<Object, ObjectEntry> cacheMap = new LinkedHashMap<Object, ObjectEntry>();

	@Override
	public void putToCache(Object key, ObjectEntry entry) {

		entry.setAccessCount(1);
		entry.setLastAccessedDate(new Date());
		cacheMap.put(key, entry);

	}

	@Override
	public ObjectEntry getFromCache(Object key) {
		// TODO Auto-generated method stub
		ObjectEntry oe = cacheMap.get(key);
		if (oe != null) {
			oe.setAccessCount(oe.getAccessCount() + 1);
			oe.setLastAccessedDate(new Date());
		}
		return oe;
	}

	@Override
	public Object getOldestKey() {
		// TODO Auto-generated method stub
		int i = 0;

		for (Map.Entry<Object, ObjectEntry> entry : cacheMap.entrySet()) {
			return entry.getKey();
		}

		return null;
	}

	@Override
	public Integer getMaxSize() {
		return maxSize;
	}

	@Override
	public void removeFromCache(Object key) {
		cacheMap.remove(key);
	}

	@Override
	public Integer count() {
		// TODO Auto-generated method stub
		return cacheMap.size();
	}

	@Override
	public LinkedHashMap<Object, ObjectEntry> getAllEntries() {
		// TODO Auto-generated method stub
		return cacheMap;
	}

	@Override
	public Object getLFUKey() {
		Integer max = 0;
		Object key = null;

		for (Map.Entry<Object, ObjectEntry> entry : cacheMap.entrySet()) {
			Integer accesscount = entry.getValue().getAccessCount();
			if (accesscount > max) {
				max = accesscount;
				key = entry.getKey();
			}
		}
		return key;
	}

	@Override
	public Object getLRUKey() {
		Date oldest = new Date();
		Object key = null;

		for (Map.Entry<Object, ObjectEntry> entry : cacheMap.entrySet()) {
			Date date = entry.getValue().getLastAccessedDate();
			if (date.compareTo(oldest) < 0) {
				oldest = date;
				key = entry.getKey();
			}
		}
		return key;
	}

}
