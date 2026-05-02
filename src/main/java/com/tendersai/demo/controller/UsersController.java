package com.tendersai.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tendersai.demo.DTO.RegisterRequest;
import com.tendersai.demo.DTO.RegisterResponse;
import com.tendersai.demo.service.UserService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UsersController {

    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public RegisterResponse getMethodName(@RequestBody RegisterRequest param) {
        return userService.CreateUser(param);
    }
    // @PostMapping("/login")
    // public String postMethodName(@RequestBody String entity) {
        
    //     return entity;
    // }
    

}
