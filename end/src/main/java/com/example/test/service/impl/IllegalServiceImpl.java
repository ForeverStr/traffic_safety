package com.example.test.service.impl;

import com.example.test.dao.IllegalDAO;
import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Illegal;
import com.example.test.model.Params;
import com.example.test.service.IllegalService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IllegalServiceImpl implements IllegalService {

    @Autowired
    private IllegalDAO illegalDAO;

    @Override
    public PageInfo<Illegal> getAll(Params params) {

        PageHelper.startPage(params);
        List<Illegal> list = illegalDAO.getAll();
        return PageInfo.of(list);
    }

    @Override
    public PageInfo<Illegal> getByDevice(Params params) {
        PageHelper.startPage(params);
        List<Illegal> list = illegalDAO.getByDevice(params);
        return PageInfo.of(list);
    }
}
