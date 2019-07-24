package com.qk.bookservice.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qk.bookservice.dao.CustomerRepository;
import com.qk.bookservice.model.Customer;

@RestController
@CrossOrigin(origins="*")
public class MainController {
	@Autowired
	private CustomerRepository customerRepo;
	
	private final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/api/greeting")
	public String hello() {
		LOG.info("Inside hello from Book Service api");
		return "Hello there now from Book Service api";
	}
	
	@PostMapping("/save")
	public String process(){
		// save a single Customer
//		customerRepo.save(new Customer("Quyen", "Smith"));
		
		// save a list of Customers
//		repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
//										new Customer("David", "Williams"), new Customer("Peter", "Davis")));
		
		return "Done";
	}
	
	
	@GetMapping("/findall")
	public String findAll(){
		String result = "";
		
		for(Customer cust : customerRepo.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	
	@GetMapping("/findbyid")
	public String findById(@RequestParam("id") long id){
		String result = "";
		result = customerRepo.findById(id).toString();
		return result;
	}
	
	@GetMapping("/findbylastname")
	public String fetchDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";
		
		for(Customer cust: customerRepo.findByLastName(lastName)){
			result += cust.toString() + "<br>"; 
		}
		
		return result;
	}
}

