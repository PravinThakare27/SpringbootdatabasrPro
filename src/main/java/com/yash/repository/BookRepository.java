package com.yash.repository;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
public Book findByIsbn(int isbn);
}
