package com.example.demo.service;

import com.example.demo.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findOne(long id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(long id);
}