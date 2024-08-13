package com.example.test.dataObject;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "pwd")
    private String pwd;

    @Column(name = "phone")
    private String phone;

    private String gender;

    private int age;



}
