package com.example.test.service.impl;

import com.example.test.dao.FlowDAO;
import com.example.test.dataObject.Flow;
import com.example.test.model.Params;
import com.example.test.service.FlowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlowServiceImpl implements FlowService {

    @Autowired
    private FlowDAO flowDAO;

    @Override
    public List<Flow> getAll() {
        return flowDAO.getAll();
    }

    @Override
    public PageInfo<Flow> getById(Params params) {
        PageHelper.startPage(params);
        List<Flow> flows =  flowDAO.getById(params);
        return PageInfo.of(flows);
    }

}
