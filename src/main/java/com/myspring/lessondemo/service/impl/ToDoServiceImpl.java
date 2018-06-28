package com.myspring.lessondemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.lessondemo.domain.ToDoEntity;
import com.myspring.lessondemo.domain.ToDoEsEntity;
import com.myspring.lessondemo.domain.UserEntity;
import com.myspring.lessondemo.dto.ToDoDto;
import com.myspring.lessondemo.dto.UserDto;
import com.myspring.lessondemo.repository.ToDoEsRepository;
import com.myspring.lessondemo.repository.ToDoRepository;
import com.myspring.lessondemo.service.ToDoService;

@Service
public class ToDoServiceImpl implements ToDoService {

	private Mapper mapper;

	private ToDoRepository todoRepo;

	@Autowired
	ToDoRepository todoRepository;

	@Autowired
	ToDoEsRepository todoEsRepository;

	public ToDoServiceImpl(Mapper mapper, ToDoRepository todoRepo) {

		this.mapper = mapper;

		this.todoRepo = todoRepo;

	}

	@Override
	public List<ToDoDto> getToDos() {
		List<ToDoDto> returnValue = new ArrayList<>();

		//List<ToDoEntity> todos = todoRepository.findAll();
		Iterable<ToDoEsEntity> todos = todoEsRepository.findAll();

		for (ToDoEsEntity toDoEntity : todos) {
	 
		/*	ToDoDto todoDto = new ToDoDto();
			BeanUtils.copyProperties(todoEntity, todoDto);*/
			returnValue.add(mapper.map(toDoEntity, ToDoDto.class));
		}

		return returnValue;
	}

	@Override
	public ToDoDto createToDo(ToDoDto todoDto) {

		ToDoEntity todoEntity = new ToDoEntity();
		//BeanUtils.copyProperties(todo, todoEntity);
		todoEntity = mapper.map(todoDto, ToDoEntity.class);

		ToDoEntity storedToDoDetails = todoRepository.save(todoEntity);

		ToDoEsEntity todoEsEntity =  mapper.map(storedToDoDetails, ToDoEsEntity.class);
		//BeanUtils.copyProperties(todo, todoEsEntity);
		todoEsRepository.save(todoEsEntity);

		// ToDoDto returnValue = new ToDoDto();
		// BeanUtils.copyProperties(storedToDoDetails, returnValue);
		ToDoDto returnValue = new ToDoDto();
		returnValue = mapper.map(storedToDoDetails, ToDoDto.class);
		return returnValue;

	}

	@Override
	public ToDoDto getToDoById(long toDoId) {
		ToDoDto returnValue = new ToDoDto();
		ToDoEntity toDoEntity = todoRepository.findById(toDoId).get();

		if (toDoEntity == null)
			throw new RuntimeException("ToDo with ID: " + toDoId + " not found");

		// BeanUtils.copyProperties(todoEntity, returnValue);
		returnValue = mapper.map(toDoEntity, ToDoDto.class);

		return returnValue;
	}
	
	@Override
	public ToDoDto updateToDo(long toDoId, ToDoDto toDo) {
		ToDoDto returnValue = new ToDoDto();

		ToDoEntity toDoEntity = todoRepository.findById(toDoId).get();

		if (toDoEntity == null)
			throw new RuntimeException("ToDo with ID: " + toDoId + " not found");

		toDoEntity.setDescription(toDo.getDescription());
		toDoEntity.setStatus(toDo.getStatus());
		//toDoEntity.setUser(toDo.getUser());

		ToDoEntity updatedUserDetails =  todoRepository.save(toDoEntity);
		returnValue = mapper.map(updatedUserDetails , ToDoDto.class);
		//BeanUtils.copyProperties(updatedUserDetails, returnValue);
	
		return returnValue;
	} 
	
	@Transactional
	@Override
	public void deleteToDo(long toDoId) {
		ToDoEntity toDoEntity = todoRepository.findById(toDoId).get();

		if (toDoEntity == null)
			throw new RuntimeException("User with ID: " + toDoId + " not found");

		todoRepository.delete(toDoEntity);
		ToDoEsEntity toDoEsEntity = todoEsRepository.findByToDoId(toDoId);
		todoEsRepository.delete(toDoEsEntity);

	}

}
