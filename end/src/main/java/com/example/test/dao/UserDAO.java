package com.example.test.dao;


import com.example.test.dataObject.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@Repository
public interface UserDAO extends Mapper<User> {

    List<User> getAll();

    /**
     * 分页查询
     * @return
     */
    List<User> getPageName(String name);

    /**
     * 按姓名查找，用于用户登录
     * @param name
     * @return
     */
    User getByName(@Param("name") String name);


    /**
     * 增添用户，用于用户注册
     * @param user
     * @return
     */
    int add(User user);

    /**
     * 更新用户信息，根据姓名
     * @param user
     * @return 1
     */
    int update(User user);

    /**
     *
     * @param user
     * @return 1
     */
    int del(User user);
}
