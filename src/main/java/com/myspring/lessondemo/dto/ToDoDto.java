package com.myspring.lessondemo.dto;

import java.io.Serializable;
import java.util.Date;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;



public class ToDoDto implements Serializable{

	private static final long serialVersionUID = 6835192601898364280L;
	@Field (type = FieldType.Long)
	private long toDoId;

    private String description;

    private String status;
	//Field defines the ES mapping
	//JsonFormat specifies the date format from the client(Postman)
	@Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:mm:ss.SSS'Z'")
    private Date targetDate;
//  default "targetDate": "2018-03-07T12:03:04.1234",
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
	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

    
}
