package com.example.test.dao;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Illegal;
import com.example.test.model.Params;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IllegalDAO {

    List<Illegal> getAll();

    List<Illegal> getByDevice(@Param("params") Params params);



}
