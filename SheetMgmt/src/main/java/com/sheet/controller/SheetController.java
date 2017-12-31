package com.sheet.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sheet.model.Customer;
import com.sheet.repository.CustomerRepository;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping(path = "api/v1/customer/")
public class SheetController {

	@Autowired
	private CustomerRepository customerRepository;

	@ApiOperation(value = "Create Customer ", notes = "It will create Customer", response = String.class)
	@RequestMapping(path = "/create", method = RequestMethod.POST)
	@Transactional
	public @ResponseBody String createCustomer(@RequestBody Customer customer) {
		customer.setPurchaseDateTime(new Timestamp(new Date().getTime()));
		customerRepository.save(customer);
		return "Saved";
	}

	@ApiOperation(value = "Retrieve Customer detail", response = Customer.class)
	@RequestMapping(path = "retrieveCustomer/{customerId}", method = RequestMethod.GET)
	public @ResponseBody Customer retrieveCustomer(@PathVariable("customerId") Integer customerId) {
		Customer customer = customerRepository.findOne(customerId);
		return customer;
	}

	@ApiOperation(value = "Update Customer detail", response = Customer.class)
	@RequestMapping(path = "/update", method = RequestMethod.PUT)
	@Transactional
	public @ResponseBody Customer updateCustomer(@RequestBody Customer customer) {
		customer.setPurchaseDateTime(new Timestamp(new Date().getTime()));
		Customer updatedCustomer = customerRepository.save(customer);
		return updatedCustomer;
	}

	@ApiOperation(value = "Delete Customer ",response = String.class)
	@RequestMapping(path = "/delete/{customerId}", method = RequestMethod.DELETE)
	@Transactional
	public @ResponseBody String deleteCustomer(@PathVariable("customerId") Integer customerId) {
		customerRepository.delete(customerId);
		return "delete";
	}

	@ApiOperation(value = "Retrieve all customer details ", notes = "Retrieve all customer details", response = List.class)
	@GetMapping(path = "/retrieveAllCustomer")
	public @ResponseBody List<Customer> retrieveAllCustomer() {
		List<Customer> findAll = customerRepository.findAll();
		return findAll;
	}

	@ApiOperation(value = "Retrieve all customer details by customer Name ", notes = "Retrieve all customer details by customer name", response = List.class)
	@GetMapping(path = "/retrieveCustomerByName")
	public @ResponseBody List<Customer> retrieveCustomers(@PathVariable("customerName") String customerName) {
		List<Customer> findAll = null;
		if (customerName.isEmpty()) {
			findAll = customerRepository.findAll();
		} else {
			findAll = customerRepository.findByName(customerName);
		}
		return findAll;
	}

}