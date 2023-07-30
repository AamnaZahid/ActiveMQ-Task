package com.activemq.service2.service;

import com.activemq.service2.consumer.Service2Consumer;
import com.activemq.service2.dto.Service1Dto;
import com.activemq.service2.dto.Service2Dto;
import com.activemq.service2.dto.Service2NewDto;
import com.activemq.service2.model.Service2Model;
import com.activemq.service2.repository.Service2Repository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class Service2CrudServices {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Service2Repository service2Repository;

    public List<Service2Model> getUser2() {
        return service2Repository.findAll();
    }

    public String addUser2(Service2Dto service2Dto) {
        Service2Model service2Model = new Service2Model();
        service2Model.setUserId(service2Dto.getUserId());
        service2Model.setName(service2Dto.getName());
        service2Model.setEmail(service2Dto.getEmail());
        service2Model.setPh_no(service2Dto.getPhNo());
        service2Repository.save(service2Model);
        return "Post added successfully!";
    }
}