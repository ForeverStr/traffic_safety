package com.example.test.dao;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Project;
import com.example.test.dataObject.User;
import com.example.test.model.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectDAO {

    List<Project> getAll();

    List<Project> getById(String device_id);

    int del(Project project);

    int update(Project project);

}
