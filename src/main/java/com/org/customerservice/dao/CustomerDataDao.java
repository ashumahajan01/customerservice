package com.org.customerservice.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.org.customerservice.model.Customer;

@Repository
public class CustomerDataDao {
	@Autowired
	EntityManager entityManager;

	public List<Customer> searchByCustomerName(String firstName, String lastName) {
		List<Customer> customerList = null;
		try {
			StringBuilder queryBuilder = new StringBuilder("Select c from Customer c ");
			String optr = "where ";
			if (firstName != null && !firstName.trim().equals("")) {
				queryBuilder.append(optr);
				queryBuilder.append("c.firstName = '" + firstName + "'");
				optr = " and ";
			}
			if (lastName != null && !lastName.trim().equals("")) {
				queryBuilder.append(optr);
				queryBuilder.append("c.lastName = '" + lastName + "'");
			}
			customerList = entityManager.createQuery(queryBuilder.toString()).getResultList();
			return customerList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
