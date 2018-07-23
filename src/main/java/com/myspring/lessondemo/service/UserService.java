package com.myspring.lessondemo.service;


import java.util.List;

import com.myspring.lessondemo.dto.UserDto;
import org.springframework.security.core.userdetails.UserDetailsService;


public interface UserService extends UserDetailsService {
	
	UserDto getUserByUserId(String userId);
	UserDto createUser(UserDto user);
	UserDto getUser(String email);
	UserDto updateUser(long userId, UserDto user);
	void deleteUser(long userId);
	List<UserDto> getUsers();
}
