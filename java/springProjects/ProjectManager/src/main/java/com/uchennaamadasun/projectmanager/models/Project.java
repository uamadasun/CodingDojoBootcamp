package com.uchennaamadasun.projectmanager.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="projects")
public class Project {
	
	//ATTRIBUTES
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message="Title is required")
	private String title;
	
	@NotEmpty
	@Size(min=3, message="Description needs to be longer than 3 characters")
	private String description;
	
	@Future(message="Date must be in the future")
	@NotNull(message="Date must be included")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date dueDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User teamLead;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name="users_are_on_projects",
			joinColumns = @JoinColumn(name="project_id"),
			inverseJoinColumns = @JoinColumn(name="user_id")
			)
	private List<User> projectTeam;
	
	@OneToMany(mappedBy="project", fetch = FetchType.LAZY)
    private List<Task> tasks;
	
	@Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
  //CREATE EMPTY CONSTRUCTOR
    public Project() {}
    
    
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Date getDueDate() {
		return dueDate;
	}


	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}


	public User getTeamLead() {
		return teamLead;
	}


	public void setTeamLead(User teamLead) {
		this.teamLead = teamLead;
	}


	public List<User> getProjectTeam() {
		return projectTeam;
	}


	public void setProjectTeam(List<User> projectTeam) {
		this.projectTeam = projectTeam;
	}


	public List<Task> getTasks() {
		return tasks;
	}


	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
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
