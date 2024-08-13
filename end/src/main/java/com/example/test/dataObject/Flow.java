package com.example.test.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Table(name = "project")
public class Flow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Timestamp time;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "car_flow")
    private int carFlow;

    @Column(name = "person_flow")
    private int personFlow;


}
