package com.myspring.lessondemo.controller;

import com.myspring.lessondemo.dto.ToTestDto;
import com.myspring.lessondemo.response.ToTestRest;
import com.myspring.lessondemo.service.ToTestService;
import com.myspring.lessondemo.ui.model.request.ToTestDetailsRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("totests")
public class ToTestController {

    private Mapper mapper;

    @Autowired
    ToTestService toTestService;

    public ToTestController(Mapper mapper) {

        this.mapper = mapper;
    }

    @GetMapping(path="/{id}")
    public ToTestRest gettoTest(@PathVariable String id)
    {
        ToTestRest returnValue = new ToTestRest();

        ToTestDto toTestDto = toTestService.getToTestById(Long.valueOf(id));

        returnValue = mapper.map(toTestDto, ToTestRest.class);

        //BeanUtils.copyProperties(toTestDto, returnValue);

        return returnValue;
    }

    @PostMapping()
    public ToTestRest createtoTest(@RequestBody ToTestDetailsRequestModel toTestDetails) throws Exception
    {
        ToTestRest returnValue = new ToTestRest();

        ToTestDto toTestDto = new ToTestDto();
        toTestDto = mapper.map(toTestDetails, ToTestDto.class);
        //BeanUtils.copyProperties(toTestDetails, toTestDto);

        ToTestDto createdtoTest = toTestService.createToTest(toTestDto);
        //	BeanUtils.copyProperties(createdtoTest, returnValue);
        returnValue = mapper.map(createdtoTest, ToTestRest.class);

        return returnValue;
    }

    @GetMapping()
    public List<ToTestRest> getToTests()
    {
        List<ToTestRest> returnValue = new ArrayList<>();

        List<ToTestDto> toTests = toTestService.getToTests();

        for (ToTestDto toTestDto : toTests) {
            ToTestRest toTestModel = new ToTestRest();
            toTestModel =mapper.map(toTestDto, ToTestRest.class);
            returnValue.add(toTestModel);
            //   BeanUtils.copyProperties(userDto, userModel);

        }

        return returnValue;
    }

    @DeleteMapping(path="/{id}")
    public void deleteUser(@PathVariable String id)
    {
        toTestService.deleteToTest((Long.valueOf(id)));
        return;
    }


}
