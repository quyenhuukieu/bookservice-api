package com.qk.bookservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.qk.bookservice.dao.CustomerRepository;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages= {"com.qk.bookservice"})
public class MainApplication {
//public class SpringJpaPostgreSqlApplication implements CommandLineRunner{

//	@Autowired
//	CustomerRepository repository;
	
	public static void main(String[] args){
		SpringApplication.run(MainApplication.class, args);
	}

//	@Override
//	public void run(String... arg0) throws Exception {
//		// clear all record if existed before do the tutorial with new data 
//		repository.deleteAll();
//	}
}
