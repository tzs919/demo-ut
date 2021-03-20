package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@RestController
@RequestMapping("/store")
public class StoreController {
    @GetMapping(produces = "application/json")
    public String store() throws IOException {
        File file = ResourceUtils.getFile("classpath:store.json");
        return new String(Files.readAllBytes(file.toPath()));
    }
}
