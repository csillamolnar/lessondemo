package com.myspring.lessondemo.dto;

import java.io.Serializable;

public class ToTestDto implements Serializable{
	

	private static final long serialVersionUID = 6835192601898364280L;
	private long id;
    private String description;
    private String status;
    private long userId;

    
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
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
	
    
}
