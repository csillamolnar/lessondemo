package com.myspring.lessondemo.response;

import com.myspring.lessondemo.domain.UserEntity;

import java.util.Date;

public class ToDoRest {

    private String description;
    private String status;



	private Date targetDate;
    private UserEntity user;
    

	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
}
