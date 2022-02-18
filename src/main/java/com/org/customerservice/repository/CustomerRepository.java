package com.org.customerservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.org.customerservice.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {	

}

