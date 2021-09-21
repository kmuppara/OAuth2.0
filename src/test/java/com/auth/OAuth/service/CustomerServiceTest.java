
package com.auth.OAuth.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.auth.OAuth.vo.Customer;

@RunWith(SpringRunner.class)
public class CustomerServiceTest {
	
	@InjectMocks
	CustomerService customerService;
	
	@Before
	public void setUp() {
		 MockitoAnnotations.openMocks(this);
	}
	
	//METHOD NAMING PATTERN: methodName_input_output()
	
	@Test 
	public void getProfile_string_customer() {
		Customer customer = customerService.getProfile("test");
		Assert.assertEquals("test", customer.getName());
	}
	
	@Test
	public void getProfile_null_null() {
		Customer customer = customerService.getProfile(null);
		Assert.assertNull(customer);
	}

}
