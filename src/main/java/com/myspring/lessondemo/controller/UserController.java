package com.myspring.lessondemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.lessondemo.dto.UserDto;
import com.myspring.lessondemo.response.UserRest;
import com.myspring.lessondemo.service.UserService;
import com.myspring.lessondemo.ui.model.request.UserDetailsRequestModel;



@RestController
@RequestMapping("users") // http://localhost:8080/users
public class UserController {
	
	@Autowired
	UserService userService;

	@GetMapping(path="/{id}")
	public UserRest getUser(@PathVariable String id)
	{
		UserRest returnValue = new UserRest();
		
		UserDto userDto = userService.getUserByUserId(Long.valueOf(id));
		BeanUtils.copyProperties(userDto, returnValue); 
		
		return returnValue;
	}
	
	@PostMapping()
	public UserRest createUser(@RequestBody UserDetailsRequestModel userDetails) throws Exception
	{
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
	    UserDto createdUser = userService.createUser(userDto);
		BeanUtils.copyProperties(createdUser, returnValue);

	    return returnValue;
	} 
	
	@GetMapping()
	public List<UserRest> getUsers()
	{
		List<UserRest> returnValue = new ArrayList<>();
		
		List<UserDto> users = userService.getUsers();
		
        for (UserDto userDto : users) {
            UserRest userModel = new UserRest();
            BeanUtils.copyProperties(userDto, userModel);
            returnValue.add(userModel);
        }
		
		return returnValue;
	} 
	
	@PutMapping(path="/{id}")
	public UserRest updateUser(@PathVariable String id, @RequestBody UserDetailsRequestModel userDetails)
	{
		UserRest returnValue = new UserRest();

		UserDto userDto = new UserDto();
		BeanUtils.copyProperties(userDetails, userDto);
		
	    UserDto updateUser = userService.updateUser(Long.valueOf(id), userDto);
		BeanUtils.copyProperties(updateUser, returnValue);

	    return returnValue;
	} 
	
	@DeleteMapping(path="/{id}")
	public void deleteUser(@PathVariable String id)
	{
		userService.deleteUser((Long.valueOf(id)));
		return;
	} 

} 