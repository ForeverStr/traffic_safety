package com.example.test.api;

import com.example.test.dataObject.Flow;
import com.example.test.model.Params;
import com.example.test.model.Result;
import com.example.test.service.FlowService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("flow")
public class FlowApi {

    @Autowired
    private FlowService flowService;

    @GetMapping("/getAll")
    public Result getAll(){
        List<Flow> flows = flowService.getAll();
        if (flows == null){
            return Result.error("未查找到用户信息");
        }else {
            return Result.success(flows);
        }

    }

    @GetMapping("/getById")
    public Result getById( Params params){
        PageInfo<Flow> flows = flowService.getById(params);
        if (flows == null){
            return Result.error("该设备暂无流量记录");
        }else {
            return Result.success(flows);
        }
    }

}
