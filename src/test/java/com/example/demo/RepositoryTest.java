package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("ut2")
public class RepositoryTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void testFindAll() throws Exception {
        User user= new User();
        user.setId(3L);
        user.setUsername("taozs");
        user.setPassword("3333333");
        userMapper.insertUser(user);
        List<User> users = userMapper.findAll();
        System.out.println(users);
    }

}
