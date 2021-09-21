package com.auth.OAuth.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.auth.OAuth.service.CustomerService;
import com.auth.OAuth.vo.Customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class CustomerControllerTest {
	
	@InjectMocks
	CustomerController customerController;
	
	private MockMvc mockMvc;
	
	@Mock
	CustomerService customerService;
	
	@Before
	public void setUp() {
		 MockitoAnnotations.openMocks(this);
		 this.mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();
	}

	//METHOD NAMING PATTERN: methodName_input_output()
	@Test
	public void getProfile_string_customer() throws Exception {
		
		Mockito.when(customerService.getProfile("test")).thenReturn(getCustomerWithName("test"));
		
		 this.mockMvc.perform(get("/api/users/profile/test")
				     .accept(MediaType.APPLICATION_JSON))
	                 .andExpect(status().isOk());
	}
	
	@Test
	public void getProfile_empty_null() throws Exception {
		Mockito.when(customerService.getProfile("")).thenReturn(getCustomerWithName(null));
		
		this.mockMvc.perform(get("/api/users/profile/")
				    .accept(MediaType.APPLICATION_JSON))
	                .andExpect(status().isOk());
	}
	
	private Customer getCustomerWithName(String name) {
		Customer customer = new Customer();
		customer.setEmail(name);
		customer.setEmail(new StringBuilder(name).append("@gmail.com").toString());
		return customer;
	} 

}
