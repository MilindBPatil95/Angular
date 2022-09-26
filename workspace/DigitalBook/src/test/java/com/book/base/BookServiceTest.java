package com.book.base;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.book.base.entity.Author;
import com.book.base.entity.Book;
import com.book.base.service.BookService;

@SpringBootTest
public class BookServiceTest {

	@MockBean
	private BookService bookService;

	public Book getBook() {
		//Author author1 = new Author(2, "Jack", "Rowling", "rowling@gamil.com");

		Book book = new Book(17l, "Harry Potter", "bloomsbury publisher", null, 123.33, "comic","*****content*****",
				"http://localhost:8080/digitalBooks/createBook/image", true, "Jack");

		

//		book.setBookId(17l);
//		book.setTitle("Harry Potter 10");
//		book.setPublisher("bloomsbury publisher");
//
//		book.setDate(null);
//		book.setPrice(230.44);
//		book.setCategory("comic");
//
//		book.setImage("http://localhost:8080/digitalBooks/createBook/image");
//		book.setActive(true);
//		book.setAuthorFirstName("Jack");
//
//		book.setAuthor(author1);
//
		return book;
	}

	@Test
	public void createBookTest() {
 
	 Book book =	getBook();
		Mockito.when(bookService.createBook(book)).thenReturn(book);

	}

	@Test
	public void getBooksByCategoryTest()
	{
	
		List<Book> books =new ArrayList<Book>();
		books.add(getBook());
    	
    	Mockito.when(bookService.getBooksByCategory("comic")).thenReturn(books);
    	
    	
    	
		
	}

	@Test
	public void getBooksByAuthorTest() {
		List<Book> books =new ArrayList<Book>();
		books.add(getBook());
  
		Mockito.when(bookService.getBooksByAuthor("Jack")).thenReturn(books);
		
	}

	@Test
	public void getBooksByPriceTest() {
		List<Book> books =new ArrayList<Book>();
		books.add(getBook());
		Mockito.when(bookService.getBooksByPrice(99.44)).thenReturn(books);

	}

	@Test
	public void getBooksByPublisherTest() {

		List<Book> books =new ArrayList<Book>();
		books.add(getBook());
  
		Mockito.when(bookService.getBooksByPublisher("bloomsbury publisher")).thenReturn(books);
		
	}

}
