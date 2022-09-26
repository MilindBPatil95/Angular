package com.book.base.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import com.book.base.utility.Message;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authorId;
	@Pattern(regexp = "[^\\s][A-Za-z\\s]*",message = Message.INVALID_FIRST_NAME)
	private String firstName;
	@Pattern(regexp = "[A-Za-z]*",message = Message.INVALID_LAST_NAME)
	private String lastName;
	@Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}",message = Message.INVALID_EMAIL_ID)
	private String emailId;
	
	@Override
	public String toString() {
		return "Author [authorId=" + authorId + ", firstName=" + firstName + ", lastName=" + lastName + ", emailId="
				+ emailId + "]";
	}

	public Author() {
		// TODO Auto-generated constructor stub
	}
	
	public Author(int authorId, @Pattern(regexp = "[A-Za-z]*") String firstName,
			@Pattern(regexp = "[A-Za-z]*") String lastName,
			@Pattern(regexp = "[a-zA-Z0-9_\\-\\.]+[@][a-z]+[\\.][a-z]{2,3}") String emailId) {
		super();
		this.authorId = authorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	

}
