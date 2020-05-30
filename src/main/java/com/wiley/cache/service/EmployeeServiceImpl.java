package com.wiley.cache.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wiley.cache.dto.CachableObject;
import com.wiley.cache.dto.Employee;
import com.wiley.cache.dto.RootObject;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired()
	
	private CacheService<RootObject> cacheService;
	@Override
	public void save(Employee newEmployee) {
		//insert to db not implemented
		CachableObject<String, Employee> emp = new CachableObject<String, Employee>(newEmployee.getId(), newEmployee);
		cacheService.putToCache(emp);
		
	}

	@Override
	public void remove(String id) {
		//remove from db not implemented
		cacheService.removeFromCache(id);
	}

	@Override
	public Employee get(String id) {
		Employee emp = cacheService.getFromCache(id);
		/**
		 * if(emp==null){
		 * fetchFromDB() not implemented
		 * }
		 */
		return emp;
	}

}
