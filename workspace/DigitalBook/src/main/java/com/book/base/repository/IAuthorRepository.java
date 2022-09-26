package com.book.base.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.book.base.entity.Author;

@Repository
public interface IAuthorRepository extends JpaRepository<Author, Long>{

	Author findByFirstName(String authorFirstName);

}
