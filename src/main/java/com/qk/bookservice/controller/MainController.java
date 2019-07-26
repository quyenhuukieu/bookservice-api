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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qk.bookservice.dao.BookRepository;
import com.qk.bookservice.dao.CustomerRepository;
import com.qk.bookservice.model.Book;
import com.qk.bookservice.model.Customer;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/api")
public class MainController {
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private BookRepository bookRepo;
	
	private final Logger LOG = LoggerFactory.getLogger(MainController.class);
	
	@GetMapping("/greeting")
	public String hello() {
		LOG.info("Inside hello from Book Service api");
		return "Hello there now from Book Service api";
	}
	
	@GetMapping("/book/findall")
	public String findAllBooks(){
		String result = "";
		
		for(Book book : bookRepo.findAll()){
			result += book.toString() + "<br>";
		}
		
		return result;
	}
	
	@PostMapping("/customer/save")
	public String processCustomer(){
		// save a single Customer
//		customerRepo.save(new Customer("Quyen", "Smith"));
		
		// save a list of Customers
//		repository.save(Arrays.asList(new Customer("Adam", "Johnson"), new Customer("Kim", "Smith"),
//										new Customer("David", "Williams"), new Customer("Peter", "Davis")));
		
		return "Done";
	}
	
	
	@GetMapping("/customer/findall")
	public String findAllCustomers(){
		String result = "";
		
		for(Customer cust : customerRepo.findAll()){
			result += cust.toString() + "<br>";
		}
		
		return result;
	}
	
	@GetMapping("/customer/findbyid")
	public String findCustomerById(@RequestParam("id") long id){
		String result = "";
		result = customerRepo.findById(id).toString();
		return result;
	}
	
	@GetMapping("/customer/findbylastname")
	public String fetchCustomerDataByLastName(@RequestParam("lastname") String lastName){
		String result = "";
		
		for(Customer cust: customerRepo.findByLastName(lastName)){
			result += cust.toString() + "<br>"; 
		}
		
		return result;
	}
}

