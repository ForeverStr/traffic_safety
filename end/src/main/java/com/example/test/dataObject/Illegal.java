package com.example.test.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Table(name = "project")
public class Illegal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_id")
    private String deviceId;

    @Column(name = "person_picture")
    private String personPicture;

    private String plate;

    @Column(name = "car_picture")
    private String carPicture;
}
