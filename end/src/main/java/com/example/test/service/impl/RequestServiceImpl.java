package com.example.test.service.impl;

import com.example.test.dao.RequestDAO;
import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Request;
import com.example.test.model.Params;
import com.example.test.service.RequestService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    private RequestDAO requestDAO;

    @Override
    public PageInfo<Request> getById(Params params) {
        PageHelper.startPage(params);
        List<Request> requests = requestDAO.getById(params);
        return PageInfo.of(requests);
    }
}
