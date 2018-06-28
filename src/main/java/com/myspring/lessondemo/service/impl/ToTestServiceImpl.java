package com.myspring.lessondemo.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.myspring.lessondemo.domain.*;
import org.dozer.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.lessondemo.dto.ToTestDto;
import com.myspring.lessondemo.repository.ToTestRepository;

import com.myspring.lessondemo.repository.ToTestEsRepository;
import com.myspring.lessondemo.service.ToTestService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ToTestServiceImpl implements ToTestService {

	private Mapper mapper;

	private ToTestRepository toTestRepo;
	
	@Autowired
	ToTestRepository toTestRepository;

	@Autowired
	ToTestEsRepository toTestEsRepository;

	public ToTestServiceImpl(Mapper mapper, ToTestRepository toTestRepo) {

		this.mapper = mapper;

		this.toTestRepo = toTestRepo;

	}

	@Override
	public List<ToTestDto> getToTests() {
		List<ToTestDto> returnValue = new ArrayList<>();

		List<ToTestEntity> tests = toTestRepository.findAll();
	
		
        for (ToTestEntity toTestEntity : tests) {
            ToTestDto toTestDto = new ToTestDto();

			returnValue.add(mapper.map(toTestEntity, ToTestDto.class));
        }
		
		return returnValue;
	}


	@Override
	public ToTestDto createToTest(ToTestDto toTestDto) {

		ToTestEntity toTestEntity = new ToTestEntity();
		//BeanUtils.copyProperties(todo, todoEntity);
		toTestEntity = mapper.map(toTestDto, ToTestEntity.class);

		ToTestEntity storedToTestDetails = toTestRepository.save(toTestEntity);

		ToTestEsEntity toTestEsEntity =  mapper.map(storedToTestDetails, ToTestEsEntity.class);
		//BeanUtils.copyProperties(todo, todoEsEntity);
		toTestEsRepository.save(toTestEsEntity);

		// ToDoDto returnValue = new ToDoDto();
		// BeanUtils.copyProperties(storedToDoDetails, returnValue);
		ToTestDto returnValue = new ToTestDto();
		returnValue = mapper.map(storedToTestDetails, ToTestDto.class);
		return returnValue;

	}

	@Override
	public ToTestDto getToTestById(long toTestId) {
		ToTestDto returnValue = new ToTestDto();
		ToTestEntity toTestEntity = toTestRepository.findById(toTestId).get();

		if (toTestEntity == null)
			throw new RuntimeException("ToDo with ID: " + toTestId + " not found");

		// BeanUtils.copyProperties(todoEntity, returnValue);
		returnValue = mapper.map(toTestEntity, ToTestDto.class);

		return returnValue;
	}

	@Override
	public ToTestDto updateToTest(long toTestId, ToTestDto toDo) {
		ToTestDto returnValue = new ToTestDto();

		ToTestEntity toTestEntity = toTestRepository.findById(toTestId).get();

		if (toTestEntity == null)
			throw new RuntimeException("ToDo with ID: " + toTestId + " not found");

		toTestEntity.setDescription(toDo.getDescription());
		toTestEntity.setStatus(toDo.getStatus());
		//toDoEntity.setUser(toDo.getUser());

		ToTestEntity updatedUserDetails =  toTestRepository.save(toTestEntity);
		returnValue = mapper.map(updatedUserDetails , ToTestDto.class);
		//BeanUtils.copyProperties(updatedUserDetails, returnValue);

		return returnValue;
	}

	@Transactional
	@Override
	public void deleteToTest(long toTestId) {
		ToTestEntity toTestEntity = toTestRepository.findById(toTestId).get();

		if (toTestEntity == null)
			throw new RuntimeException("User with ID: " + toTestId + " not found");

		toTestRepository.delete(toTestEntity);
		ToTestEsEntity toTestEsEntity = toTestEsRepository.findByToTestId(toTestId);
		toTestEsRepository.delete(toTestEsEntity);

	}
}
