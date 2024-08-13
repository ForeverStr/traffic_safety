package com.example.test.service;

import com.example.test.dataObject.User;
import com.example.test.model.Params;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface UserService {

    PageInfo<User> getAll(Params params);

    PageInfo<User> getPageName(Params params);

    User getByName( User user);

    int add(@RequestBody User user);

    int update(User user);

    int del(User user);
}
