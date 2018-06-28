package com.myspring.lessondemo.dto;

import java.io.Serializable;


import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



public class ToDoDto implements Serializable{

	private static final long serialVersionUID = 6835192601898364280L;
	@Field(type = FieldType.Long)
	private long toDoId;
    private String description;
    private String status;
	@Field(type = FieldType.Nested)
    private UserDto user;
  
    

	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}
	public long getToDoId() {
		return toDoId;
	}
	public void setToDoId(long toDoId) {
		this.toDoId = toDoId;
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
	
/*	public UserDto getUser() {
		return user;
	}
	public void setUser(UserDto user) {
		this.user = user;
	}*/
	
    
}
