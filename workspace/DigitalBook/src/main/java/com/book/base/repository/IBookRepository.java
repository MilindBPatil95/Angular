package com.book.base.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.base.entity.Book;
@Repository
public interface IBookRepository extends JpaRepository<Book,Long> {

	List<Book> findAllByCategory(String category);

	List<Book> findAllByAuthorFirstName(String author);

	List<Book> findAllByPrice(Double price);

	List<Book> findAllByPublisher(String publisher);

}
