package com.yash.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Library")
public class Librarian {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	 private String name;
	 private String gmail;
	 private String password;
	 private String mobile;
	
	 
	 
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
		name = name;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		mobile = mobile;
	}
	
	public Librarian(int id, String name, String gmail, String password, String mobile) {
		super();
		this.id = id;
		this.name = name;
		this.gmail = gmail;
		this.password = password;
		this.mobile = mobile;
	}
	public Librarian() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	 
	
}
