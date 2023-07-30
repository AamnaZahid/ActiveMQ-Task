package com.activemq.service2.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "Service2table")
public class Service2Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name="ph_no")
    private String ph_no;
}
