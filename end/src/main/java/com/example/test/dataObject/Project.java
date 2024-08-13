package com.example.test.dataObject;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;

@Data
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "device_id")
    private String deviceId;

    private String lon;

    private String lat;

    private int fault;

    @Column(name = "is_repaired")
    private int isRepaired;

    private String plate;

    @Column(name = "manage_id")
    private String manageId;

    private String message;


}
