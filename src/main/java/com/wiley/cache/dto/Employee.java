package com.wiley.cache.dto;

public class Employee extends RootObject {
	private String name;
	private String address;

	public Employee() {

	}

	public Employee(String id, String name, String address) {
		super(id);
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
