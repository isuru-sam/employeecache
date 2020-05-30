package com.wiley.cache.service;

import com.wiley.cache.dto.Employee;

public interface EmployeeService {

	public void save(Employee e);

	public void remove(String id);

	public Employee get(String id);

}
