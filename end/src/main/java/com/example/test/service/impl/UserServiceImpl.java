package com.example.test.service.impl;

import com.example.test.dao.UserDAO;
import com.example.test.dataObject.User;
import com.example.test.model.Params;
import com.example.test.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public PageInfo<User> getAll(Params params) {
        PageHelper.startPage(params);
        List<User> users =  userDAO.getAll();
        return PageInfo.of(users);
    }

    @Override
    public PageInfo<User> getPageName(Params params) {
        PageHelper.startPage(params);
        List<User> users = userDAO.getPageName(params.getName());
        return PageInfo.of(users);
    }

    @Override
    public User getByName(User user) {
        return userDAO.getByName(user.getName());
    }


    @Override
    public int add(@RequestBody User user) {
        return userDAO.add(user);
    }

    @Override
    public int update(User user) {
        return userDAO.update(user);
    }

    @Override
    public int del(User user) {
        return userDAO.del(user);
    }

}
