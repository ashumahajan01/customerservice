package com.org.customerservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.org.customerservice.model.Address;
import com.org.customerservice.model.Customer;
import com.org.customerservice.model.CustomerName;
import com.org.customerservice.service.CustomerDataService;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/customerapi")
public class CustomerServiceController {

	@Autowired
	CustomerDataService customerDataService;
	
	@PostMapping("/addcustomer")
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		return customerDataService.addCustomer(customer);
	}

	@GetMapping("/customers")
	public ResponseEntity<?> getCustomersList() {
		return customerDataService.getAllCustomers();
	}

	@PutMapping("/updateaddress/{custid}")
	public ResponseEntity<?> updateCustomerAddress(@PathVariable("custid") long id,	@RequestBody Address address) {
		return customerDataService.updateCustomerAddress(id, address);
	}

	@GetMapping("/searchcustomers")
	public ResponseEntity<?> searchByFirstAndOrLastName(@RequestBody CustomerName customerName) {
		return customerDataService.searchByFirstAndOrLastName(customerName.getFirstName(), customerName.getLastName());
	}

}
