package com.yash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Librarian;
import com.yash.model.Student;

public interface LibraryRepository extends CrudRepository<Student,Integer> {
public List<Student> findByEmailidAndPassword(String emailid,String password);

}
