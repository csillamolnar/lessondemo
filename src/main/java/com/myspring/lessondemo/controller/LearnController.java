package com.myspring.lessondemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myspring.lessondemo.domain.ToLearn;
import com.myspring.lessondemo.dto.UserDto;
import com.myspring.lessondemo.response.UserRest;
import com.myspring.lessondemo.service.LearnService;
import com.myspring.lessondemo.service.LearnComposer.LearnComposer;

@RestController
@RequestMapping("learncomposer") 
public class LearnController {
	@Autowired
	private LearnService learnService;
	
	@GetMapping("/all")
	public List<ToLearn> getAllLearnComposer()
	{
		return learnService.getLearnComposer().getToLearnList();
		
	} 
}
