package com.example.test.service;

import com.example.test.dataObject.Flow;
import com.example.test.model.Params;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FlowService {

    List<Flow> getAll();

    PageInfo<Flow> getById(Params params);

}
