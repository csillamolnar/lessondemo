package com.myspring.lessondemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myspring.lessondemo.service.LearnComposer.LearnComposer;

@Service
public interface LearnService {
	LearnComposer getLearnComposer();
	
	
}
