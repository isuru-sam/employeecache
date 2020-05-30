package com.wiley.cache.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.wiley.cache.dto.RootObject;
import com.wiley.cache.service.CacheService;
import com.wiley.cache.service.LFUCacheServiceImpl;
import com.wiley.cache.service.LRUCacheServiceImpl;
import com.wiley.cache.service.StorageService;

@Configuration
public class CacheConfiguration {
	@Bean
	@ConditionalOnProperty(name = "cacheEvictionStratergy", havingValue = "LRU")
	public CacheService<RootObject> LRUCahceBean(@Qualifier("storageService") StorageService storageService) {

		return new LRUCacheServiceImpl(storageService);
	}

	@Bean
	@ConditionalOnProperty(name = "cacheEvictionStratergy", havingValue = "LFU")
	public CacheService<RootObject> LFUCahceBean(@Qualifier("storageService") StorageService storageService) {

		return new LFUCacheServiceImpl(storageService);
	}

	@Bean(name = "storageService")
	@ConditionalOnProperty(name = "cacheLevel", havingValue = "Memory")
	public StorageService InmemoryStorageService() {

		return new com.wiley.cache.service.InmemoryStorageService();
	}

	@Bean(name = "storageService")
	@ConditionalOnProperty(name = "cacheLevel", havingValue = "File")
	public StorageService FileStorageService() {

		return new com.wiley.cache.service.FileStorageService();
	}
}
