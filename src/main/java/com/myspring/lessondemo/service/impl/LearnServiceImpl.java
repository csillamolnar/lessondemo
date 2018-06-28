package com.myspring.lessondemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.lessondemo.domain.ToDoEntity;
import com.myspring.lessondemo.domain.ToTestEntity;
import com.myspring.lessondemo.repository.ToDoRepository;
import com.myspring.lessondemo.repository.ToTestRepository;
import com.myspring.lessondemo.service.LearnService;
import com.myspring.lessondemo.service.LearnComposer.LearnComposer;

@Service
public class LearnServiceImpl implements LearnService {
	
	@Autowired
	ToDoRepository todoRepository;
	
	@Autowired
	ToTestRepository testRepository;

	@Override
	public LearnComposer getLearnComposer() {
		
		 LearnComposer learnJavaCert = new LearnComposer();
		 List<ToDoEntity> todos = todoRepository.findAll();
			
			
	      for (ToDoEntity todoEntity : todos) {
	            learnJavaCert.addLesson(todoEntity);
	        }
		
		  List<ToTestEntity> totests = testRepository.findAll();

				
		   for (ToTestEntity totestEntity : totests) {
		            learnJavaCert.addLesson(totestEntity);
		        }
			
		
		 return learnJavaCert;
	} 
}
