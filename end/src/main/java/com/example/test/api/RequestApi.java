package com.example.test.api;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Request;
import com.example.test.model.Params;
import com.example.test.model.Result;
import com.example.test.service.RequestService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("request")
public class RequestApi {

    @Autowired
    private RequestService requestService;

    @GetMapping("/getById")
    public Result getById(Params params){
        PageInfo<Request> request = requestService.getById(params);
        if (request == null){
            return Result.error("该设备暂无申请记录");
        }else {
            return Result.success(request);
        }
    }


}
