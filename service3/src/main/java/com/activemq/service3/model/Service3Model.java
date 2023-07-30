package com.activemq.service3.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
@ToString
@Table(name = "Service3table_Card")
public class Service3Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private long userId;
    @Column(name="name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "card_type")
    private String cardType;
    @Column(name="ph_no")
    private String ph_no;
}
