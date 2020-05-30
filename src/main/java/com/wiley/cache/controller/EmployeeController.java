package com.wiley.cache.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wiley.cache.dto.Employee;
import com.wiley.cache.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired()

	private EmployeeService employeeService;

	@PostMapping(path = "/save")
	public ResponseEntity<Employee> newEmployee(@RequestBody Employee newEmployee) {
		employeeService.save(newEmployee);
		return ResponseEntity.ok(newEmployee);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") String id) {
		Employee emp = employeeService.get(id);
		return ResponseEntity.ok(emp);
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id) {
		employeeService.remove(id);
		return ResponseEntity.ok(id);
	}

}
