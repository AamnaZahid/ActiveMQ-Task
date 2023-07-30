package com.activemq.service2.controller;

import com.activemq.service2.dto.Service2Dto;
import com.activemq.service2.model.Service2Model;
import com.activemq.service2.service.Service2CrudServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class Service2ControllerMappingCrud {
    @Autowired
    private Service2CrudServices service2Services;
    @RequestMapping(value = "/getuser2",method = RequestMethod.GET)
    public List<Service2Model> getAllUsers (){
        return service2Services.getUser2();
    }

    @RequestMapping(value = "/adduser2", method = RequestMethod.POST)
    public String addUser2(@RequestBody Service2Dto service2Dto) throws JsonProcessingException {
          service2Services.addUser2(service2Dto);
          return "User2Data Added Successfully";
    }
}

