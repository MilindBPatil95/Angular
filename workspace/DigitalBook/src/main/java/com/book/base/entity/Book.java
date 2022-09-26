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
import javax.validation.constraints.Pattern;

import com.book.base.utility.Message;

@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bookId")
	private Long bookId;
	@NotBlank
	@Pattern(regexp = "[^\\s][A-Za-z\\s]*", message = Message.INVALID_TITLE)
	private String title;
	@NotBlank(message = Message.INVALID_PUBLISHER)
	@Pattern(regexp = "[^\\s][A-Za-z\\s]*")
	private String publisher;
	@Temporal(TemporalType.DATE)
	private Date date;
//	@NotBlank(message = Message.INVALID_PRICE)
	private Double price;
	@NotBlank
	@Pattern(regexp = "[^\\s][A-Za-z\\s]*", message = Message.INVALID_CATEGORY)
	private String category;
	@NotBlank
	private String content;

	@NotBlank(message = Message.IMAGE)
	private String image;
	private Boolean active;
	@Pattern(regexp = "[^\\s][A-Za-z\\s]*", message = Message.INVALID_AUTHOR_FIRST_NAME)
	private String authorFirstName;
 
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long bookId, String title, String publisher, Date date, Double price, String category,String content, String image,
			Boolean active, String authorFirstName) {
		super();
		this.bookId = bookId;
		this.title = title;
		this.publisher = publisher;
		this.date = date;
		this.price = price;
		this.category = category;
		this.content= content;
		this.image = image;
		this.active = active;
		this.authorFirstName = authorFirstName;
	
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
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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


}
