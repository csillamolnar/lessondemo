package com.myspring.lessondemo.service;

import java.util.List;

import com.myspring.lessondemo.dto.ToDoDto;


public interface ToDoService {
	List<ToDoDto> getToDos();
	ToDoDto createToDo(ToDoDto todo);
	
	ToDoDto getToDoById(long todoId);


	ToDoDto updateToDo(long todoId, ToDoDto todo);
	void deleteToDo(long todId);
	
	
}
