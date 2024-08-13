package com.example.test.dao;

import com.example.test.dataObject.Flow;
import com.example.test.model.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FlowDAO {

    List<Flow> getAll();

    List<Flow> getById(@Param("params") Params params);

}
