package com.wiley.cache.service;

import com.wiley.cache.dto.CachableObject;
import com.wiley.cache.dto.ObjectEntry;
import com.wiley.cache.dto.RootObject;

public class LRUCacheServiceImpl implements CacheService<RootObject> {

	private StorageService storageService;

	public LRUCacheServiceImpl(StorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public void putToCache(CachableObject<? extends String, ? extends RootObject> object) {
		ObjectEntry o = new ObjectEntry(object.getValue());

		if (storageService.getFromCache(object.getKey()) == null) {

			Integer max = storageService.getMaxSize();
			Integer count = storageService.count();
			// lru eviction
			if (count == max) {
				Object lruKey = storageService.getLRUKey();
				if (lruKey == null) {

					lruKey = storageService.getOldestKey();
				}

				storageService.removeFromCache(lruKey);
			}
		}
		storageService.putToCache(object.getKey(), o);

	}

	@SuppressWarnings("unchecked")
	@Override
	public RootObject getFromCache(String key) {
		ObjectEntry o = (ObjectEntry) storageService.getFromCache(key);
		if (o == null) {
			return null;
		}

		return (RootObject) o.getObject();

	}

	@Override
	public String removeFromCache(String key) {
		// TODO Auto-generated method stub
		storageService.removeFromCache(key);
		return key;
	}

}
