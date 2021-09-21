package com.auth.OAuth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.auth.OAuth.service.CustomerService;
import com.auth.OAuth.vo.Customer;

@Controller("/api/users")
public class CustomerController 
{
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/profile/{name}")
	public ResponseEntity<Customer> getProfile(@PathVariable String name) 
	{
		return ResponseEntity.ok(customerService.getProfile(name));
	}
}
