package com.myspring.lessondemo.dto;

import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

public class ToTestDto implements Serializable {


    private static final long serialVersionUID = 6835192601898364280L;

    @Field
            (
                    type = FieldType.Long
            )
    private long toTestId;
    private String description;
    private String status;
    @Field(
            type = FieldType.Nested
    )
    private UserDto user;


    public long getToTestId() {
        return toTestId;
    }

    public void setToTestId(long toTestId) {
        this.toTestId = toTestId;
    }

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
