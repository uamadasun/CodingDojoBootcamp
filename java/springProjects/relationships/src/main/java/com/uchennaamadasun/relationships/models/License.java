package com.uchennaamadasun.relationships.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

//...
@Entity
@Table(name="licenses")
public class License {
 
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;
 private String number;
 private Date expirationDate;
 private String state;
 @Column(updatable=false)
 private Date createdAt;
 private Date updatedAt;
 @OneToOne(fetch=FetchType.LAZY)
 @JoinColumn(name="person_id")
 private Person person;
 public License() {
     
 }
 
 // ...
 // getters and setters removed for brevity
 // ...
}


