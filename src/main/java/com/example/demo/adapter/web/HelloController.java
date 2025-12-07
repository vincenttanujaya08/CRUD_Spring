package com.example.demo.adapter.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "Hi";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }
}
