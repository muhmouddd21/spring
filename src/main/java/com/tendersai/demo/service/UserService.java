package com.tendersai.demo.service;

import org.springframework.stereotype.Service;

import com.tendersai.demo.DTO.RegisterRequest;
import com.tendersai.demo.DTO.RegisterResponse;
import com.tendersai.demo.entity.User;
import com.tendersai.demo.repository.Interfaces.UserRepo;

@Service
public class UserService {
    private final UserRepo userRepo;
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public long getUserCount() {
        return userRepo.count();
    }

    public RegisterResponse CreateUser(RegisterRequest request) {
        User user = new User(
            request.name(),
            request.email(),
            request.password()
        );
        User savedUser = userRepo.save(user);
        return new RegisterResponse(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail(),
            "User registered successfully"
        );
    }

}
