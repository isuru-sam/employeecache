package com.wiley.cache.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wiley.cache.dto.Employee;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class EmployeeServiceTest {
	@Autowired
	private EmployeeService employeeService;

	@Test
	public void testSaveEmployee() {

		Employee in = new Employee("1", "abc", "def");

		employeeService.save(in);

		Employee out = employeeService.get("1");
		assertEquals(in.getId(), out.getId());

	}
	
	@Test
	public void testRemoveEmployee() {
		Employee in = new Employee("1", "abc", "def");

		employeeService.save(in);
		employeeService.remove("1");
		Employee out = employeeService.get("1");
		assertNull(out);
		
	}
	
	@Test
	public void testLRU() {
		//maxSize==3 so after 4th one 1st one is removed
		Employee in = new Employee("1", "abc", "def");
		employeeService.save(in);
		Employee in2 = new Employee("2", "abc", "def");
		employeeService.save(in2);
		Employee in3 = new Employee("3", "abc", "def");
		employeeService.save(in3);
		Employee in4 = new Employee("4", "abc", "def");
		employeeService.save(in4);
		employeeService.get("2");
		employeeService.get("3");
		employeeService.get("4");
		Employee out = employeeService.get("1");
		assertNull(out);
		out = employeeService.get("2");
		assertEquals("2", out.getId());

		
	}
	
}
