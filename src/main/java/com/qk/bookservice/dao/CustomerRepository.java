package com.qk.bookservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qk.bookservice.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	List<Customer> findByLastName(String lastName);
}
