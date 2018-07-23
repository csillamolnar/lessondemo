package com.myspring.lessondemo.response;

import com.myspring.lessondemo.domain.UserEntity;

public class ToTestRest {
    private String description;
    private String status;
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
}
