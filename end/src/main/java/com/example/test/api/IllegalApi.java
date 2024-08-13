package com.example.test.api;

import com.example.test.dataObject.Flow;
import com.example.test.dataObject.Illegal;
import com.example.test.dataObject.Project;
import com.example.test.model.Params;
import com.example.test.model.Result;
import com.example.test.service.IllegalService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("ill")
public class IllegalApi {

    @Autowired
    private IllegalService illegalService;

    @GetMapping("getAll")
    public Result getAll( Params params){
        PageInfo<Illegal> projects = illegalService.getAll(params);
        if (projects == null){
            return Result.error("未查找到设备信息");
        }else {
            return Result.success(projects);
        }
    }

    @GetMapping("/getByDevice")
    public Result getByDevice( Params params){
        PageInfo<Illegal> illegal = illegalService.getByDevice(params);
        if (illegal == null){
            return Result.error("该设备暂无流量记录");
        }else {
            return Result.success(illegal);
        }
    }

}
