package com.example.test.service.impl;

import com.example.test.dao.ProjectDAO;
import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Project;
import com.example.test.model.Params;
import com.example.test.service.ProjectService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectDAO projectDAO;


    @Override
    public PageInfo<Project> getAll(Params params) {
        PageHelper.startPage(params);
        List<Project> list = projectDAO.getAll();
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<Project> getById(Params params) {
        PageHelper.startPage(params);
        List<Project> list = projectDAO.getById(params.getId());
        return PageInfo.of(list) ;
    }

    /**
     * 开启分页后对数据进行操作而导致的分页异常尚未解决
     * @param list
     * @return
     */
    private List<Project> getProjectList(List<Project> list) {
        Map<String,Project> id = new HashMap<>();
        for (Project res : list){
            id.putIfAbsent(res.getDeviceId(), res);
        }
        Set<Map.Entry<String,Project>> entries = id.entrySet();
        List<Project> result = new ArrayList<>();
        for (Map.Entry<String,Project> str : entries){
            result.add(str.getValue());
        }
        return result;
    }

    @Override
    public List<Project> getForMap() {
        return projectDAO.getAll();
    }

    @Override
    public int del(Project project) {
        return projectDAO.del(project);
    }

    @Override
    public int update(Project project) {
        return projectDAO.update(project);
    }
}
