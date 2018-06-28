package com.myspring.lessondemo.service;

import java.util.List;

import com.myspring.lessondemo.dto.ToTestDto;


public interface ToTestService {
	List<ToTestDto> getToTests();
	ToTestDto createToTest(ToTestDto toTest);

	ToTestDto getToTestById(long toTestId);


	ToTestDto updateToTest(long toTestId, ToTestDto toTest);
	void deleteToTest(long toTestId);
	
}
