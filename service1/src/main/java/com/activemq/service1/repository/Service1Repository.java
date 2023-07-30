package com.activemq.service1.repository;

import com.activemq.service1.model.Service1Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Service1Repository extends JpaRepository<Service1Model,Long>
{
}
