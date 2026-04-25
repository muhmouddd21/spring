package com.tendersai.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tendersai.demo.entity.HelloResponse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
public class HelloController {

    @GetMapping("/")
    public HelloResponse hello() {
        return new HelloResponse("Hello, World!");
    }
    @GetMapping("/mahmoud")
    public HelloResponse getMethodName(@RequestParam String param) {
        return new HelloResponse("Hello, " + param + "!");
    }
    @GetMapping("/greet/{name}")
    public HelloResponse greet(@PathVariable String name) {
        return new HelloResponse("Hello, " + name + "!");
    }
    

}
