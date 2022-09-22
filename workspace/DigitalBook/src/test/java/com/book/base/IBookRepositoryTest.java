package com.book.base;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.book.base.entity.Author;
import com.book.base.entity.Book;
import com.book.base.repository.IBookRepository;
@SpringBootTest
public class IBookRepositoryTest {

	@Autowired
	private IBookRepository bookRepository;

	@Test
	void contextLoads() {
		
	}	

	@SuppressWarnings("deprecation")
	@Test
	public void createBookTest() {
		Author author1 = new Author(2,"Jack","Rowling","rowling@gamil.com");
		

//		Book book = new Book(17l, "Harry Potter", "bloomsbury publisher", new Date("1997-01-11"), 123.33, "comic",
//				"http://localhost:8080/digitalBooks/createBook/image", true, "Jack", author1);
		
		Book book= new Book();
		
		book.setBookId(17l);
		book.setTitle("Harry Potter 9");
		book.setPublisher("bloomsbury publisher");
        
		book.setDate(new Date(2011,1,2));
		book.setPrice(230.44);
		book.setCategory("comic");
		
		book.setImage("http://localhost:8080/digitalBooks/createBook/image");
		book.setActive(true);
        book.setAuthorFirstName("Jack");
        
        book.setAuthor(author1);
        
		Book book1=bookRepository.save(book);
		assertThat(book1).isNotNull();

		
	}
	
	@Test
	public void getBooksByCategoryTest()
	{
	
		List<Book> expectedList= bookRepository.findAllByCategory("comic");
		
    	assertThat(expectedList).size().isGreaterThan(0);	
		
	}
	
	
	@Test
	public void getBooksByAuthorTest()
	{
		List<Book> expectedList = bookRepository.findAllByAuthorFirstName("Micle");
    	
		assertThat(expectedList.get(0).getPrice()).isEqualTo(124.33);;	
		
	}
	@Test
	public void getBooksByPriceTest()
	{
		
    	assertThat(bookRepository.findAllByPrice(120.00d)).size().isGreaterThan(0);	
		
	}
	@Test
	public void getBooksByPublisherTest()
	{
		
    	assertNotNull(bookRepository.findAllByPublisher("Moon publisher"));	
	}
	
	

}
