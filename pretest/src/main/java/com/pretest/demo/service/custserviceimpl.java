package com.pretest.demo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pretest.demo.exception.NotFoundException;
import com.pretest.demo.model.Customer;
import com.pretest.demo.repository.custrepository;

@Service
public class custserviceimpl implements custservice {
	
	
	Logger logger = LoggerFactory.getLogger(custserviceimpl.class);

	@Autowired
	custrepository custRepository;
	
	public List<Customer> getAllCustomer() {

		logger.info("Getting all Customer details");
		List<Customer> allCustomerList = custRepository.findAll();
		if (allCustomerList.isEmpty()) {
			throw new NotFoundException("No Customer available");
		}
		return allCustomerList;

	}
	public String deleteCustomer(Long id) {

		logger.info("Deleting Customer by id");
		if (custRepository.existsById(id)) {
			custRepository.deleteById(id);
			logger.info("Customer Deleted");
			return "Customer Deleted with Customer Id : " + id;
			
		} else {
			throw new NotFoundException("Customer with Id " + id + " not exist");
		}

	}
	public String updateCustomer(Customer customer, Long id ) {
		logger.info("Updating Customer details");

		Optional<Customer> list = custRepository.findById(id);
		System.out.println(list);
		if (!list.isPresent())
			throw new NotFoundException("Customer with the id " + id + "not exist");
		custRepository.deleteById(id);
		custRepository.save(customer);
		logger.info("Updated Successfully");
		return "Customer Updated with: " + customer.getId();

	}
	
	
	public Optional<Customer> getCustomer(Long id) {

		logger.info("Getting Customer by id");
		Optional<Customer> cust = custRepository.findById(id);
		if (!cust.isPresent()) {
			throw new NotFoundException("No Customer available with id : " + id);
		}
		logger.info("Successful search of Booking by id");
		return cust;

	}
	
	
	public Customer addCustomer(Customer cust) throws NotFoundException {
		logger.info("Adding a new Customer");
		if (custRepository.existsById(cust.getId()))
            throw new NotFoundException();
        else {
            Customer newCust = custRepository.save(cust);
            logger.info("Added Customer");
            return newCust;
		}
	}
	
	
	
}
