package com.yash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Librarian;
import com.yash.model.Student;

public interface LibrarianRepository extends CrudRepository<Librarian,Integer> {
	public List<Librarian> findByGmailAndPassword(String gmail,String password);
}
