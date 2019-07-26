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
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookRepository bookRepo;
	
	private final Logger LOG = LoggerFactory.getLogger(BookController.class);
	
	@GetMapping("/greeting")
	public String hello() {
		LOG.info("Inside hello from Book Controller");
		return "Hello there now from Book Controller";
	}
	
	@GetMapping("/findall")
	public String findAllBooks(){
		String result = "";
		
		for(Book book : bookRepo.findAll()){
			result += book.toString() + "<br>";
		}
		
		return result;
	}
}

