package com.activemq.service2.repository;

import com.activemq.service2.model.Service2Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Service2Repository extends JpaRepository<Service2Model,Long>
{
}
