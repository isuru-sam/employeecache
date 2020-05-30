package com.wiley.cache.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wiley.cache.dto.Employee;
import com.wiley.cache.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc

public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private EmployeeService employeeService;

	@Test
	public void testSaveEmployee() throws Exception {
		Employee in = new Employee("1", "abc", "def");
		String requestBody = asJsonString(in);
		String responseBody = requestBody;
		this.mockMvc
				.perform(MockMvcRequestBuilders.post("/save").content(requestBody)
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(responseBody));
	}

	@Test
	public void testGetEmployee() throws Exception {
		Employee in = new Employee("1", "abc", "def");
		String requestBody = asJsonString(in);
		String responseBody = requestBody;

		when(employeeService.get("1")).thenReturn(in);

		this.mockMvc
				.perform(MockMvcRequestBuilders.get("/{id}", "1")
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string(responseBody));

	}

	@Test
	public void testRemoveEmployee() throws Exception {

		this.mockMvc
				.perform(MockMvcRequestBuilders.delete("/{id}", "1")
						.contentType(org.springframework.http.MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().string("1"));

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
