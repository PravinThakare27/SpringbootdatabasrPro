package com.yash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="book")
public class Book
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
int isbn;
String author;
String title;
String category;
String publisher;
int price;
int quantity;
String status;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public int getIsbn() {
	return isbn;
}
public void setIsbn(int isbn) {
	this.isbn = isbn;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getCategory() {
	return category;
}
public void setCategory(String category) {
	this.category = category;
}
public String getPublisher() {
	return publisher;
}
public void setPublisher(String publisher) {
	this.publisher = publisher;
}
public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Book() {
	super();
	// TODO Auto-generated constructor stub
}
public Book(String author, String title, String category, String publisher, int price, int quantity) {
	super();
	this.author = author;
	this.title = title;
	this.category = category;
	this.publisher = publisher;
	this.price = price;
	this.quantity = quantity;
}

}
