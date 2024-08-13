package com.example.test.service;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Request;
import com.example.test.model.Params;
import com.github.pagehelper.PageInfo;

public interface RequestService {

    PageInfo<Request> getById(Params params);

}
