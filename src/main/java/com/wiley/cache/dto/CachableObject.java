package com.wiley.cache.dto;

public class CachableObject<U , V > {

	private U key;
	private V value;

	public CachableObject(U key, V value) {
		this.key = key;
		this.value = value;
	}

	public U getKey() {
		return key;
	}

	public void setKey(U key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

}
