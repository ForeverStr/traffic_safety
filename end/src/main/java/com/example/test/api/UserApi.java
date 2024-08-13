package com.example.test.api;

import com.example.test.dataObject.User;
import com.example.test.model.Params;
import com.example.test.model.Result;
import com.example.test.service.UserService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/user")
public class UserApi {

    @Autowired
    private UserService userService;

    @GetMapping("getAll")
    public Result getAll(Params params){
        PageInfo<User> users =  userService.getAll(params);
        if (users == null){
            return Result.error("未查找到用户信息");
        }
        return Result.success(users);
    }

    @GetMapping("getPageName")
    public Result getPageName( Params params){
        PageInfo<User> user = userService.getPageName(params);
        if (user == null){
            return Result.error("查询内容为空");
        }
        return Result.success(user);
    }


    @PostMapping("update")
    @ResponseBody
    public Result update(@RequestBody User user){
        int result = userService.update(user);
        if (result == 1){
            return Result.success(result);
        }else {
            return Result.error("更新失败");
        }
    }

    @PostMapping("del")
    @ResponseBody
    public Result del(@RequestBody User user){
        int result = userService.del(user);
        if (result == 1){
            return Result.success(result);
        }else {
            return Result.error("删除失败，注意传参");
        }
    }
    //登录
    @PostMapping("login")
    @ResponseBody
    public Result login(@RequestBody User user){
        Result result = new Result();
        User user1 = userService.getByName(user);
        if (user1 != null){
            if (user.getPwd().equals(user1.getPwd())){
                result.setCode("0");
                result.setData(user);
            }else {
                result.setCode("-1");
                result.setMsg("密码错误");
            }
            return result;
        }else {
            return Result.error("用户不存在");
        }
    }

    //注册
    @PostMapping("register")
    @ResponseBody
    public Result register(@RequestBody User user){
        Result result = new Result();
        if (user.getPwd().isEmpty() || user.getName().isEmpty()){
            result.setCode("-1");
            result.setMsg("请输入用户名或密码");
            return result;
        }else {
            User user1 = userService.getByName(user);
            if (user1 != null){
                result.setCode("-1");
                result.setMsg("用户已存在，直接登录即可");
            }else {
                int is = userService.add(user);
                result.setCode("0");
                result.setMsg("注册成功");
                result.setData(is);
            }
            return result;
        }
    }

}
