package com.pretest.demo.service;

import java.util.Optional;

import com.pretest.demo.model.Customer;

import java.util.List;

public interface custservice {

	public Customer addCustomer(Customer customer);
	
	public String deleteCustomer(Long id);
	
    public Optional<Customer> getCustomer(Long id);
	
	public List<Customer> getAllCustomer();
	
	public String updateCustomer(Customer customer, Long id);
}
