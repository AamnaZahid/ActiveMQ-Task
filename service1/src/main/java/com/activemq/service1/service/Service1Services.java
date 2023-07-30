package com.activemq.service1.service;

import com.activemq.service1.dto.Service1Dto;
import com.activemq.service1.model.Service1Model;
import com.activemq.service1.repository.Service1Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class Service1Services {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private Service1Repository service1Repository;
    public List<Service1Model> getUser()
    {
        return service1Repository.findAll();
    }

    public String addUser(Service1Dto service1Dto)
    {
        Service1Model service1Model = new Service1Model();
        service1Model.setUserId(service1Dto.getUserId());
        service1Model.setCardType(service1Dto.getCardType());
        service1Repository.save(service1Model);
        return "Post added successfully!";
    }

}
