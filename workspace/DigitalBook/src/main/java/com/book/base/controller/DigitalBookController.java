package com.book.base.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.book.base.entity.Book;
import com.book.base.repository.IAuthorRepository;
import com.book.base.service.IBookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/digitalBooks")
@CrossOrigin(origins = "*")
public class DigitalBookController {
	
	@Autowired
	private IBookService bookService;

	@PostMapping("/book")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
		System.out.println("inside create book ");
		Book book1 = bookService.createBook(book);
		return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
	}

	@GetMapping("/books/search/category/{category}")
	public ResponseEntity<List<Book>> getBooksByCategory(@PathVariable("category") String category) {
		// log.debug("inside :: getBooksByCategory");
		List<Book> books = bookService.getBooksByCategory(category);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/books/search/author/{authorFirstName}")
	public ResponseEntity<List<Book>> getBooksByAuthor(@PathVariable("authorFirstName") String authorFirstName) {
		System.out.println("inside :: getBooksByAuthor ");
		List<Book> books = bookService.getBooksByAuthor(authorFirstName);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/books/search/price/{price}")
	public ResponseEntity<List<Book>> getBooksByPrice(@PathVariable("price") Double price) {
		List<Book> books = bookService.getBooksByPrice(price);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
	}

	@GetMapping("/books/search/publisher/{publisher}")
	public ResponseEntity<List<Book>> getBooksByPublisher(@PathVariable("publisher") String publisher) {
		// log.debug("inside :: getBooksByPublisher() ");
		List<Book> books = bookService.getBooksByPublisher(publisher);
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}
	

	@GetMapping("/books/search/getAllBooks")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> books = bookService.getAllBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}
	
	@GetMapping("/books/search/buyBook/{bookId}")
	public ResponseEntity<Book> buyBook(@PathVariable("bookId") Long bookId) {
		Book book = bookService.buyBook(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);

	}
	
	@GetMapping("/books/search/getAllPurchasedBooks")
	public ResponseEntity<List<Book>> getAllPurchasedBooks() {
		List<Book> books = bookService.getAllPurchasedBooks();
		return new ResponseEntity<List<Book>>(books, HttpStatus.OK);

	}
	
	

}
