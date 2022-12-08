package com.uchennaamadasun.travels.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="expenses")
public class Expense {
	//CREATE ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max=200, message="Expense name required.")
	private String expenseName;
	
	@NotNull
	@Size(min=1, max=200, message="Vendor name required.")
	private String vendorName;
	
	@NotNull (message="Amount required.")
	@Min(value=1, message="Amount must be greater than $0.")
	private Double amount;
	
	@NotNull
	@Size(min=1, max=500, message="Description required.")
	private String description;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
	
    
	//CREATE CONSTRUCTORS
    public Expense() {}


	public Expense(String expenseName, String vendorName, Double amount,String description) {
		super();
		this.expenseName = expenseName;
		this.vendorName = vendorName;
		this.amount = amount;
		this.description = description;
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

  //GETTERS AND SETTERS
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getExpenseName() {
		return expenseName;
	}


	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}


	public String getVendorName() {
		return vendorName;
	}


	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}


	public Double getAmount() {
		return amount;
	}


	public void setAmount(Double amount) {
		this.amount = amount;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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

    


	
	

}
