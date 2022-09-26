package com.book.base.service;

import java.util.List;

import com.book.base.entity.Book;

public interface IBookService {

	Book createBook(Book book);

	List<Book> getBooksByCategory(String category);

	List<Book> getBooksByAuthor(String authorFirstName);

	List<Book> getBooksByPrice(Double price);

	List<Book> getBooksByPublisher(String publisher);

	List<Book> getAllBooks();

	Book buyBook(Long bookId);

	List<Book> getAllPurchasedBooks();

}
