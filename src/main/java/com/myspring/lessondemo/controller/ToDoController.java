package com.myspring.lessondemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
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

import com.myspring.lessondemo.dto.ToDoDto;
import com.myspring.lessondemo.dto.UserDto;
import com.myspring.lessondemo.repository.ToDoRepository;
import com.myspring.lessondemo.response.ToDoRest;
import com.myspring.lessondemo.response.UserRest;
import com.myspring.lessondemo.service.ToDoService;
import com.myspring.lessondemo.service.UserService;
import com.myspring.lessondemo.ui.model.request.ToDoDetailsRequestModel;
import com.myspring.lessondemo.ui.model.request.UserDetailsRequestModel;



@RestController
@RequestMapping("todos") // http://localhost:8080/users
public class ToDoController {
	
	private Mapper mapper;
	
	@Autowired
	ToDoService toDoService;
	
	public ToDoController(Mapper mapper) {

		this.mapper = mapper;
	}

	@GetMapping(path="/{id}")
	public ToDoRest getToDo(@PathVariable String id)
	{
		ToDoRest returnValue = new ToDoRest();
		
		ToDoDto toDoDto = toDoService.getToDoById(Long.valueOf(id));
		
		returnValue = mapper.map(toDoDto, ToDoRest.class);
		
		//BeanUtils.copyProperties(toDoDto, returnValue); 
		
		return returnValue;
	}
	
	@PostMapping()
	public ToDoRest createToDo(@RequestBody ToDoDetailsRequestModel toDoDetails) throws Exception
	{
		ToDoRest returnValue = new ToDoRest();

		ToDoDto todoDto = new ToDoDto();
		todoDto = mapper.map(toDoDetails, ToDoDto.class);
		//BeanUtils.copyProperties(toDoDetails, todoDto);
		
	    ToDoDto createdToDo = toDoService.createToDo(todoDto);
	//	BeanUtils.copyProperties(createdToDo, returnValue);
	    returnValue = mapper.map(createdToDo, ToDoRest.class);

	    return returnValue;
	} 
	
	@GetMapping()
	public List<ToDoRest> getToDos()
	{
		List<ToDoRest> returnValue = new ArrayList<>();
		
		List<ToDoDto> todos = toDoService.getToDos();
		
        for (ToDoDto toDoDto : todos) {
           ToDoRest todoModel = new ToDoRest();
           todoModel =mapper.map(toDoDto, ToDoRest.class);
           returnValue.add(todoModel);
         //   BeanUtils.copyProperties(userDto, userModel);
         
        }
		
		return returnValue;
	} 
	
	@DeleteMapping(path="/{id}")
	public void deleteUser(@PathVariable String id)
	{
		toDoService.deleteToDo((Long.valueOf(id)));
		return;
	} 
	
	

} 