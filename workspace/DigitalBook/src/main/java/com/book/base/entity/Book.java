package com.book.base.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private Long bookId;
	@NotBlank(message = "Title is required ")
	private String title;
	@NotBlank(message = "publisher name  is required ")
	private String publisher;
	@Temporal(TemporalType.DATE)
	private Date date;
	private Double price;
	@NotBlank(message = "category is required")
	private String category;
	@NotBlank(message = "image is required")
	private String image;
	private Boolean active;
	private String authorFirstName;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "authorId", referencedColumnName = "authorId")
	private Author author;
     
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, @NotBlank(message = "Title is required ") String title,
			@NotBlank(message = "publisher name  is required ") String publisher, Date date, Double price,
			@NotBlank(message = "category is required") String category,
			@NotBlank(message = "image is required") String image, Boolean active, String authorFirstName,
			Author author) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
		this.date = date;
		this.price = price;
		this.category = category;
		this.image = image;
		this.active = active;
		this.authorFirstName = authorFirstName;
		this.author = author;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public String getAuthorFirstName() {
		return authorFirstName;
	}

	public void setAuthorFirstName(String authorFirstName) {
		this.authorFirstName = authorFirstName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
}
