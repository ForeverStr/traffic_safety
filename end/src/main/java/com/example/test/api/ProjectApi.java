package com.example.test.api;

import com.example.test.dataObject.Project;
import com.example.test.dataObject.User;
import com.example.test.model.Params;
import com.example.test.model.Result;
import com.example.test.service.ProjectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("project")
public class ProjectApi {

    @Autowired
    private ProjectService projectService;


    @GetMapping("getAll")
    public Result getAll( Params params){
        PageInfo<Project> projects = projectService.getAll(params);
        if (projects == null){
            return Result.error("未查找到设备信息");
        }else {
            return Result.success(projects);
        }
    }

    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody Project project){
        int result = projectService.update(project);
        if (result != 0){
            return Result.success(result);
        }else {
            return Result.error("更新失败");
        }
    }

    @GetMapping("getForMap")
    public Result getForMap(){
        List<Project> projects = projectService.getForMap();
        if (projects == null){
            return Result.error("未查找到设备信息");
        }else {
            return Result.success(projects);
        }
    }

    @GetMapping("getById")
    public Result getPageName( Params params){
        PageInfo<Project> project  = projectService.getById(params);
        if (project == null){
            return Result.error("查询内容为空");
        }
        return Result.success(project);
    }

    @PostMapping("del")
    @ResponseBody
    public Result del(@RequestBody Project project){
        int result = projectService.del(project);
        if (result != 0){
            return Result.success(result);
        }else {
            return Result.error("删除失败，注意传参");
        }
    }
}
