package com.example.test.service;

import com.example.test.dataObject.Project;
import com.example.test.model.Params;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ProjectService {
    PageInfo<Project> getAll(Params params);

    PageInfo<Project> getById(Params params);

    /**
     * 地图方法
     * @return
     */
    List<Project> getForMap();

    int del(Project project);

    int update(Project project);
}
