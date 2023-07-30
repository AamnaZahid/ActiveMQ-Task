package com.activemq.service2.service;

import com.activemq.service2.model.Service2Model;
import com.activemq.service2.repository.Service2Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class Service2UserExistenceServices {

    @Autowired
    private Service2Repository service2Repository;

    public boolean userExistence(Long userIdToCheck)
    {
        Service2Model service2Model = new Service2Model();
        List<Service2Model> allUsers = service2Repository.findAll();
        List<Long> allUserIds = allUsers.stream().map(Service2Model::getUserId).collect(Collectors.toList());
        return allUserIds.contains(userIdToCheck);
    }
}
