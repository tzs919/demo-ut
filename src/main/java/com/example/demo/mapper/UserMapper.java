package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper//指定这是一个操作数据库的mapper
public interface UserMapper {
    List<User> findAll();

    User findOne(long id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(long id);
}
