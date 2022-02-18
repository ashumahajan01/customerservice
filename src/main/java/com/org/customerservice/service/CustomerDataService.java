package com.org.customerservice.service;

import org.springframework.http.ResponseEntity;

import com.org.customerservice.model.Address;
import com.org.customerservice.model.Customer;

public interface CustomerDataService {
	ResponseEntity<?> getAllCustomers();

	ResponseEntity<?> addCustomer(Customer customer);

	ResponseEntity<?> updateCustomerAddress(Long id, Address address);

	ResponseEntity<?> searchByFirstAndOrLastName(String firstName, String lastName);

}
