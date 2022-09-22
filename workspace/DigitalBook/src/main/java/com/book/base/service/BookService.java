package com.book.base.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.base.entity.Book;
import com.book.base.repository.IBookRepository;

@Service
public class BookService implements IBookService{
	
	@Autowired
    private IBookRepository bookRepo;

	@Override
	public Book createBook(Book book) {
		return bookRepo.save(book);		
	}

	@Override
	public List<Book> getBooksByCategory(String category) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByCategory(category);
	}

	@Override
	public List<Book> getBooksByAuthor(String authorFirstName) {
		// TODO Auto-generated method stub
		return bookRepo.findAllByAuthorFirstName(authorFirstName);
	}

	@Override
	public List<Book> getBooksByPrice(Double price) {
		return bookRepo.findAllByPrice(price);
	}

	@Override
	public List<Book> getBooksByPublisher(String publisher) {
		
		return bookRepo.findAllByPublisher(publisher);
	}

}
