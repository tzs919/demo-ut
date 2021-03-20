package com.example.demo.service.impl;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceimpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userMapper.findAll();
    }

    @Override
    public User findOne(long id) {
        return userMapper.findOne(id);
    }

    @Override
    public int insertUser(User user) {
        int i = userMapper.insertUser(user);
        System.out.println(i);
        return i;
    }

    @Override
    public int updateUser(User user) {
        int i = userMapper.updateUser(user);
        System.out.println(i);
        return i;
    }

    @Override
    public int deleteUser(long id) {
        int i = userMapper.deleteUser(id);
        System.out.println(i);
        return i;
    }

}