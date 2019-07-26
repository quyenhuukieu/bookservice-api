package com.qk.bookservice.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.qk.bookservice.model.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);
	List<Book> findByAuthor(String author);
	List<Book> findById(String id);
}
