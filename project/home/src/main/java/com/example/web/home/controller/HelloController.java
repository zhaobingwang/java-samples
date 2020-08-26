package com.example.web.home.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String Hello() {
        int a = 0;
        int b = 10 / a;
        return "heelo";
    }
}
