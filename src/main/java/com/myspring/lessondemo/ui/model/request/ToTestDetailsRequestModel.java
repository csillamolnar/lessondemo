package com.myspring.lessondemo.ui.model.request;

import com.myspring.lessondemo.dto.UserDto;

public class ToTestDetailsRequestModel {
    private String description;
    private String status;
    private UserDto user;



    public UserDto getUser() {
        return user;
    }
    public void setUser(UserDto user) {
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

}
