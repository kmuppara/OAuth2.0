package com.auth.OAuth.service;

import org.springframework.stereotype.Service;

import com.auth.OAuth.vo.Customer;

@Service
public class CustomerService {
	
	public Customer getProfile(String name) {
		
		Customer customer = null;
		if(name != null) {
			customer = new Customer();
			customer.setName(name);
			customer.setEmail(name+"@gmail.com");
		}
		
		return customer;
	}

}
