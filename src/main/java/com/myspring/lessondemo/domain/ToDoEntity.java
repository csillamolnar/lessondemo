package com.myspring.lessondemo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="todos")
public class ToDoEntity implements ToLearn{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private long toDoId;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
	
	@Column(length=120)
	private String description;
	
	@Column(name="target_date")
	private Date targetDate;
	
	@Column(length=120)
	private String status;

	public long getToDoId() {
		return toDoId;
	}

	public void setToDoId(long toDoId) {
		this.toDoId = toDoId;
	}

	public UserEntity getUser() {
        return user;
    }



    public void setUser(UserEntity user) {
        this.user = user;
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	public void showLearnStatus(){
		System.out.println("Status is printed from todo "+getStatus());
	}
	

}
