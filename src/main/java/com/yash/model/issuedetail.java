package com.yash.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class issuedetail {
@Id
private int bookid;
private int isbn;
private String title;
private String publisher;

private int id;
private String name;
private String emailid;
private String issuedate;
private String datedue;
private String bookstatus;
private String returneddate;
private int fine;

public int getFine() {
	return fine;
}
public void setFine(int fine) {
	this.fine = fine;
}
public String getReturneddate() {
	return returneddate;
}
public void setReturneddate(String returneddate) {
	this.returneddate = returneddate;
}

public String getBookstatus() {
	return bookstatus;
}
public void setBookstatus(String bookstatus) {
	this.bookstatus = bookstatus;
}
public int getBookid() {
	return bookid;
}
public void setBookid(int bookid) {
	this.bookid = bookid;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmailid() {
	return emailid;
}
public void setEmailid(String emailid) {
	this.emailid = emailid;
}
public String getIssuedate() {
	return issuedate;
}
public void setIssuedate(String currentdate) {
	this.issuedate = currentdate;
}
public String getDatedue() {
	return datedue;
}
public void setDatedue(String datedue) {
	this.datedue = datedue;
}

public issuedetail() {
	super();
	// TODO Auto-generated constructor stub
}
public issuedetail(int bookid, int isbn, String title, String publisher, int id, String name,
		String emailid, String issuedate, String datedue, String bookstatus, String returneddate, int fine) {
	super();
	this.bookid = bookid;
	this.isbn = isbn;
	this.title = title;
	this.publisher = publisher;
	
	this.id = id;
	this.name = name;
	this.emailid = emailid;
	this.issuedate = issuedate;
	this.datedue = datedue;
	this.bookstatus = bookstatus;
	this.returneddate = returneddate;
	this.fine = fine;
}



}
