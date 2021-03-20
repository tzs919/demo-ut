package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@Transactional(rollbackFor = Throwable.class)
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping(value = "/{id}")
    public User findOne(@PathVariable("id") long id) {
        return userService.findOne(id);
    }

    @PostMapping
    public int insertUser(@RequestBody User user) {
        return userService.insertUser(user);
    }

    @PutMapping
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping(value = "/{id}")
    public int deleteUser(@PathVariable("id") long id) {
        return userService.deleteUser(id);
    }
}