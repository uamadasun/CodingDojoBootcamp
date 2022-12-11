package com.uchennaamadasun.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="books")
public class Book {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required!")
	private String title;
	
	@NotEmpty(message="Author is required!")
	private String author;
	
	@NotEmpty(message="Your thoughts are required!")
	private String thoughts;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User creator;
	
	//CREATE MANY TO MANY RELATIONSHIP
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_borrows_book", 
			joinColumns = @JoinColumn(name = "book_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id")
			)
	private List<User> borrowingUsers;
	
	
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    
    
  //CREATE EMPTY CONSTRUCTOR
    public Book() {
    	
    }
    
    
  //HANDLING CREATED AT AND UPDATED AT
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getThoughts() {
		return thoughts;
	}


	public void setThoughts(String thoughts) {
		this.thoughts = thoughts;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	public List<User> getBorrowingUsers() {
		return borrowingUsers;
	}


	public void setBorrowingUsers(List<User> borrowingUsers) {
		this.borrowingUsers = borrowingUsers;
	}
    
}
