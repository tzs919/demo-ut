package com.example.demo.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@RestController
@RequestMapping("/store")
public class StoreController {
    @GetMapping(produces = "application/json")
    public String store() throws IOException {
        File file = ResourceUtils.getFile("classpath:store.json");
        return new String(Files.readAllBytes(file.toPath()));
    }
}
