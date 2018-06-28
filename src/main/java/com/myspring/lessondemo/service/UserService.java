package com.myspring.lessondemo.service;


import java.util.List;

import com.myspring.lessondemo.dto.UserDto;



public interface UserService {
	
	UserDto getUserByUserId(long userId);
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto updateUser(long userId, UserDto user);
	void deleteUser(long userId);
	List<UserDto> getUsers();
}
