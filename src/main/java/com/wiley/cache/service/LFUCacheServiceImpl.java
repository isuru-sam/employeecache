package com.wiley.cache.service;

import com.wiley.cache.dto.CachableObject;
import com.wiley.cache.dto.ObjectEntry;
import com.wiley.cache.dto.RootObject;

public class LFUCacheServiceImpl implements CacheService<RootObject> {
	private StorageService storageService;

	public LFUCacheServiceImpl(StorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public void putToCache(CachableObject<? extends String, ? extends RootObject> object) {
		ObjectEntry o = new ObjectEntry(object.getValue());
		if (storageService.getFromCache(object.getKey()) == null) {
			Integer max = storageService.getMaxSize();
			Integer count = storageService.count();

			if (count == max) {
				// LFU eviction
				Object lfukey = storageService.getLFUKey();
				Object keytoremove = null;
				if (lfukey == null) {
					keytoremove = storageService.getOldestKey();

				} else {
					keytoremove = lfukey;
				}
				storageService.removeFromCache(keytoremove);
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
		storageService.removeFromCache(key);
		return key;
	}

}
