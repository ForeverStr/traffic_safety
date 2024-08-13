package com.example.test.dao;

import com.example.test.dataObject.Request;
import com.example.test.model.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestDAO {

    List<Request> getById(@Param("params") Params params);

}
