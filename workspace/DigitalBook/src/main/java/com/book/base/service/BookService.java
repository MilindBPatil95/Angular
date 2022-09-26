package com.book.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.base.entity.Author;
import com.book.base.entity.Book;
import com.book.base.exceptionhandler.CustomExceptionHandler;
import com.book.base.exceptionhandler.GlobleExceptionHandler;
import com.book.base.repository.IAuthorRepository;
import com.book.base.repository.IBookRepository;
import com.book.base.utility.Message;

@Service
public class BookService implements IBookService {

	@Autowired 
	private IAuthorRepository authorRepository;
	
	@Autowired
	private IBookRepository bookRepo;

	@Override
	public Book createBook(Book book) {
	   Author author =	authorRepository.findByFirstName("Micle");
	   System.out.println("Author details->"+author);
	   if(author==null)
	   {
		   throw new CustomExceptionHandler.InvalidAuthorNameException(Message.INVALID_AUTHOR);
	   }
		return bookRepo.save(book);
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		List<Book> books = bookRepo.findAllByCategory(category);
		if (books.isEmpty()) {
			throw new CustomExceptionHandler.InvalidBookException(Message.EMPTY_LIST);
		}
		return books;
	}

	@Override
	public List<Book> getBooksByAuthor(String authorFirstName) {
		// TODO Auto-generated method stub
		List<Book> books=bookRepo.findAllByAuthorFirstName(authorFirstName);
		if (books.isEmpty()) {
			throw new CustomExceptionHandler.InvalidBookException(Message.EMPTY_LIST);
		}
		return books;
	}

	@Override
	public List<Book> getBooksByPrice(Double price) {
		List<Book> books= bookRepo.findAllByPrice(price);
		if (books.isEmpty()) {
			throw new CustomExceptionHandler.InvalidBookException(Message.EMPTY_LIST);
		}
		return books;
	}

	@Override
	public List<Book> getBooksByPublisher(String publisher) {

		List<Book> books= bookRepo.findAllByPublisher(publisher);
		if (books.isEmpty()) {
			throw new CustomExceptionHandler.InvalidBookException(Message.EMPTY_LIST);
		}
		return books;
	}

	@Override
	public List<Book> getAllBooks() {
		List<Book> books= bookRepo.findAll();
		if (books.isEmpty()) {
			throw new CustomExceptionHandler.InvalidBookException(Message.EMPTY_LIST);
		}
		
		return books;
	}

}
