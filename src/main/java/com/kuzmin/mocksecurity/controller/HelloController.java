package com.kuzmin.mocksecurity.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello(Authentication a) {
        return "Hello, " + a.getName() + "!";
    }

    @PostMapping("/csrf")
    public String csrf() {
        return "Hello!";
    }

    @PostMapping("/cors")
    @ResponseBody
    public String cors() {
        return "Hello!";
    }
}