package com.yash.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.yash.model.Student;
import com.yash.model.issuedetail;

public interface issuedetailRepository extends CrudRepository<issuedetail,Integer>{
issuedetail findByBookidAndId(int bookid,int id);
Iterable<issuedetail> findByBookstatus(String bookstatus);
}
