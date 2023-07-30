package com.activemq.service3.repository;

import com.activemq.service3.model.Service3Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Service3Repository extends JpaRepository<Service3Model,Long>
{
}
