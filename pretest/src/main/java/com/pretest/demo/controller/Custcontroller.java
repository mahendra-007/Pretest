package com.pretest.demo.controller;


import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pretest.demo.model.Customer;
import com.pretest.demo.service.custservice;




@RestController
@RequestMapping("/customer")
public class Custcontroller {

	Logger logger=LoggerFactory.getLogger(Custcontroller.class);
	
	  @Autowired
	  custservice custService;
	
	 
		@GetMapping("/allCustomers")
	    public List<Customer> getAllCustomers() {
	    logger.info("Getting all Customer Details");
	    List<Customer> cust= custService.getAllCustomer();
		return cust;		
		}
	    

	    
		@GetMapping("/getCustomer/{id}")
		public ResponseEntity<?> getCustomer(@PathVariable Long id) {
	    	logger.info("Getting Customer Details By customer Id");
	    	ResponseEntity<?> responseEntity = null;
	    	Optional<Customer> booking  = custService.getCustomer(id);
	    	responseEntity = new ResponseEntity<>(booking, HttpStatus.OK);
	    	logger.info("Successfull search of Customer details by Id");
			return responseEntity;
		}
	    

	   
	    @PostMapping("/addCustomer")
	    public ResponseEntity<Customer> addCustomer(@RequestBody Customer cust) {
	        logger.info("Creating a New Booking");
	        Customer newCustomer = custService.addCustomer(cust);
	        ResponseEntity<Customer> responseEntity = new ResponseEntity<Customer>(newCustomer, HttpStatus.ACCEPTED);
	        logger.info("Created a new Customer");
	        return responseEntity;
	    }
	    
	   
		@PutMapping("/updateCustomer/{id}")
		public ResponseEntity<Object> updateCustomer(@RequestBody Customer cust, @PathVariable Long id) {
	    	logger.info("Updating Customer details by id");
	    	ResponseEntity<Object> responseEntity = null;
	    	custService.updateCustomer(cust, id);
	    	responseEntity = new ResponseEntity<Object>("Customer Updated successfully", HttpStatus.OK);
			logger.info(" Customer Updated Successfully");
	    	return responseEntity;
		}
		
	   
		@DeleteMapping("/deleteCustomer/{id}")
		public ResponseEntity<Object> deleteCustomer(@PathVariable Long id) {
	    	logger.info("Deleting Customer details by Id");
	    	ResponseEntity<Object> responseEntity = null;
	    	custService.deleteCustomer(id);
	    	logger.info("Deleted Successfully");
	    	responseEntity = new ResponseEntity<Object>(" Deleted successfully", HttpStatus.OK);
			return responseEntity;
			
		}
	  
}
