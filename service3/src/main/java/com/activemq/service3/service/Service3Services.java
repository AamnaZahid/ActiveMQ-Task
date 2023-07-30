package com.activemq.service3.service;

import com.activemq.service3.dto.Service3Dto;
import com.activemq.service3.model.Service3Model;
import com.activemq.service3.repository.Service3Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class Service3Services
{
    @Autowired
    private Service3Repository service3Repository;
public boolean saveUser(Service3Dto service3Dto)
{
    Service3Model service3Model = new Service3Model();
    service3Model.setUserId(service3Dto.getUserId());
    service3Model.setName(service3Dto.getName());
    service3Model.setEmail(service3Dto.getEmail());
    service3Model.setCardType(service3Dto.getCardType());
    service3Model.setPh_no(service3Dto.getPhNo());
    service3Repository.save(service3Model);
    return true;
}
    public Optional<Service3Model> getUserById(Long userId) {
        return service3Repository.findById(userId);
    }

    }
