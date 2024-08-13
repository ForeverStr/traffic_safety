package com.example.test.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "project")
public class Request {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp time;

    @Column(name = "device_id")
    private String deviceId;

    private int request;

    private int pass;

}
