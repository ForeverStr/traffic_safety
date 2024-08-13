package com.example.test.service;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Illegal;
import com.example.test.model.Params;
import com.github.pagehelper.PageInfo;

public interface IllegalService {

    PageInfo<Illegal> getAll(Params params);

    PageInfo<Illegal> getByDevice(Params params);

}
