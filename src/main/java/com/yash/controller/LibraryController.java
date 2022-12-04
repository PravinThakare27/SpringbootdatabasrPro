package com.yash.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yash.model.Book;
import com.yash.model.Librarian;

import com.yash.model.Student;
import com.yash.model.issuedetail;
import com.yash.repository.BookRepository;
import com.yash.repository.LibrarianRepository;
import com.yash.repository.LibraryRepository;
import com.yash.repository.issuedetailRepository;

@RestController
public class LibraryController {
	@Autowired
	LibraryRepository l;
	@Autowired
	BookRepository b;
	@Autowired
	issuedetailRepository r;
	@Autowired
	LibrarianRepository rp;

	@CrossOrigin()

	@PostMapping("/login")
	public String login(@RequestBody Student s1) {
		boolean k1 = true;
		if ("admin".equals(s1.getEmailid()) == k1 && "admin".equals(s1.getEmailid()) == k1) {
			System.out.print(s1.getEmailid() + "" + s1.getPassword());
			return "admin";
		} else {
			List <Librarian> s=rp.findByGmailAndPassword(s1.getEmailid(), s1.getPassword());
		//	List<Student> s = l.findByEmailidAndPassword(s1.getEmailid(), s1.getPassword());

			String k = String.valueOf(s.isEmpty());
			return k;
		}

	}

	@PostMapping("/addbook")
	@CrossOrigin()
	public String addbook(@RequestBody Book b1) {

		if (b1.getQuantity() > 0) {
			b1.setStatus("In Stock");
			b.save(b1);
		} else {
			b1.setStatus("Not available");

			b.save(b1);
		}
		return "save";
	}

	@GetMapping(path = "/allbook")
	@CrossOrigin()
	Iterable<Book> allbook() {

		return b.findAll();

	}

	@GetMapping(path = "/allstudents")
	@CrossOrigin()
	Iterable<Student> allstudents() {

		return l.findAll();

	}

	@PostMapping("/addstud")
	@CrossOrigin()
	public String addstud(@RequestBody Student b1) {

		l.save(b1);
		return "save";
	}

	@PostMapping("/issuebook")
	@CrossOrigin()
	public String issuebook(@RequestBody issuedetail b1) {
		Book b2 = b.findById(b1.getIsbn()).get();
		Student s1 = l.findById(b1.getId()).get();
		if (b2.getIsbn() == b1.getIsbn() && s1.getId() == b1.getId() && b2.getQuantity()>0 ) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
			Date currentdate = new Date();
			ZoneId defaultZoneId = ZoneId.systemDefault();
			Instant instant = currentdate.toInstant();
			LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
			System.out.println("Local Date is: " + localDate.toString());
			Calendar c = Calendar.getInstance();
			c.setTime(currentdate);
			c.add(Calendar.DATE, 10);
			Date currentdateplus = c.getTime();
			Instant instant1 = currentdateplus.toInstant();
			LocalDate currentdateplus1 = instant1.atZone(defaultZoneId).toLocalDate();
			b1.setIssuedate(localDate.toString());
			b1.setDatedue(currentdateplus1.toString());
			b1.setBookstatus("Pending");
			b2.setQuantity(b2.getQuantity()-1);
			r.save(b1);
			b.save(b2);
			// return "save"+currentdate.toString();

			return "true";
		} else {
			return "false";
		}
	}

	@DeleteMapping(path = "/deleteissuedetail/{isbn}")
	@CrossOrigin()
	String deleteissuedetail(@PathVariable int isbn) {
		b.deleteById(isbn);
		return "delete";
	}

	@GetMapping("/editissuedetail/{id}")
	@CrossOrigin
	public Book editissuedetail(@PathVariable("id") int isbn) {
		return b.findById(isbn).get();

	}

	@PostMapping(value = "/updatebook")
	@CrossOrigin
	String updatebook(@RequestBody Book b1) {

		Book b2 = b.findById(b1.getIsbn()).get();

		b2.setAuthor(b1.getAuthor());
		b2.setCategory(b1.getCategory());
		b2.setTitle(b1.getTitle());
		b2.setPrice(b1.getPrice());
		b2.setPublisher(b1.getPublisher());
		b2.setQuantity(b1.getQuantity());

		if (b1.getQuantity() > 0) {
			b2.setStatus("In Stock");
			b.save(b2);
		} else {
			b2.setStatus("Not available");

			b.save(b2);
		}
		return "update";
	}

	@DeleteMapping(path = "/deletestud/{id}")
	@CrossOrigin()
	String deletestud(@PathVariable int id) {
		l.deleteById(id);
		return "delete";
	}

	@GetMapping("/editstuddetail/{id}")
	@CrossOrigin
	public Student editstuddetail(@PathVariable("id") int id) {
		return l.findById(id).get();

	}

	@PostMapping(value = "/updatestud")
	@CrossOrigin
	String updatestud(@RequestBody Student b1) {

		Student b2 = l.findById(b1.getId()).get();
		b2.setFirstname(b1.getFirstname());
		b2.setLastname(b1.getLastname());
		b2.setEmailid(b1.getEmailid());
		b2.setPassword(b1.getPassword());
		b2.setMobile(b1.getMobile());
		b2.setDob(b1.getDob());

		l.save(b2);

		return "update";
	}

	@PostMapping(value = "/returnbook")
	@CrossOrigin
	String returnbook(@RequestBody issuedetail i) throws ParseException {
		issuedetail j = r.findByBookidAndId(i.getBookid(), i.getId());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date currentdate = new Date();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		// Converting the date to Instant
		Instant instant = currentdate.toInstant();
		LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
		System.out.println("Local Date is: " + localDate.toString());

		String DATE_FORAT = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DATE_FORAT);
		String dateStr1 = "2021-01-01";
		String dateStr2 = "2021-01-31";
		Date date1 = simpleDateFormat.parse(j.getIssuedate());
		Date date2 = simpleDateFormat.parse(localDate.toString());
		long date1InMs = date1.getTime();
		long date2InMs = date2.getTime();
		long timeDiff = 0;
		if (date1InMs > date2InMs) {
			timeDiff = date1InMs - date2InMs;
		} else {
			timeDiff = date2InMs - date1InMs;
		}
		int daysDiff = (int) (timeDiff / (1000 * 60 * 60 * 24));
		System.out.println("No of days diff is using String Dates : " + daysDiff);

		if (daysDiff <= 10) {
			j.setBookstatus("Returned");

			j.setFine(daysDiff * 5);
			j.setReturneddate(localDate.toString());
			r.save(j);
		} else {
			j.setBookstatus("Returned");
			int finee = 0;
			j.setFine(finee);
			j.setReturneddate(localDate.toString());
			r.save(j);
		}

		return "return";


	}

	@GetMapping(value = "/returnbooktable")
	@CrossOrigin
	Iterable<issuedetail> returnbooktable() {
		return r.findByBookstatus("Returned");
	}

	@GetMapping(value = "/allissuedetail")
	@CrossOrigin
	Iterable<issuedetail> pendingbooktable() {
		return r.findByBookstatus("Pending");
	}

	@PostMapping(value = "/addli/{name}/{gmail}/{password}/{mobile}")
	@CrossOrigin
	String addlibrarian(@PathVariable("name") String name, @PathVariable("gmail") String gmail,
			@PathVariable("password") String password, @PathVariable("mobile") String mobile) {
		Librarian l = new Librarian();
		l.setId(0);
		l.setGmail(gmail);
		l.setName(name);
		l.setPassword(password);
		l.setMobile(mobile);
		System.out.println("mail" + name + "gmail" + gmail);
		Librarian l1 = new Librarian();
		l1.setId(0);
		l1.setGmail("sfs");
		l1.setName("dg");
		l1.setPassword("sgwgw");
		l1.setMobile("sgeg");

		Librarian n = new Librarian(0, name, gmail, password, mobile);
		rp.save(n);
		return "save";

	}

	@GetMapping(value = "/viewLibrarian")
	@CrossOrigin
	Iterable<Librarian> viewLibrarian() {
		return rp.findAll();
	}

}
