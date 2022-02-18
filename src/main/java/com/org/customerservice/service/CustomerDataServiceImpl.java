package com.org.customerservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.org.customerservice.dao.CustomerDataDao;
import com.org.customerservice.model.Address;
import com.org.customerservice.model.Customer;
import com.org.customerservice.repository.CustomerRepository;
import com.org.customerservice.response.CustomerResponse;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {

	@Autowired
	CustomerRepository customerDataRepository;

	@Autowired
	CustomerDataDao customerDataDao;
	
	@Override
	public ResponseEntity<?> addCustomer(Customer customer) {
		try {
			if (customer.getFirstName() == null || customer.getFirstName().equals("")) {
				CustomerResponse response = new CustomerResponse();
				response.setReason("Insufficient Data");
				response.setResult(false);
				response.setStatus("Bad Request");
				response.setStatusCode(400);
				return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
			}
			Customer _customer = customerDataRepository.save(customer);
			return new ResponseEntity<>(_customer, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> getAllCustomers() {
		try {
			List<Customer> customers = new ArrayList<Customer>();
			customerDataRepository.findAll().forEach(customers::add);
			if (customers.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> updateCustomerAddress(Long id, Address address) {
		try {
			if (id == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			Optional<Customer> customerData = customerDataRepository.findById(id);
			if (customerData.isPresent()) {
				Customer _customer = customerData.get();
				_customer.setAddress(address);
				return new ResponseEntity<>(customerDataRepository.save(_customer), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@Override
	public ResponseEntity<?> searchByFirstAndOrLastName(String firstName, String lastName) {
		if ((firstName != null && !firstName.trim().equals("")) || (lastName != null && !lastName.trim().equals(""))) {
			List<Customer> customers = customerDataDao.searchByCustomerName(firstName, lastName);
			return new ResponseEntity<>(customers, HttpStatus.OK);
		} else {
			CustomerResponse response = new CustomerResponse();
			response.setReason("Insufficient Data");
			response.setResult(false);
			response.setStatus("Bad Request");
			response.setStatusCode(400);

			return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
		}

	}

}
