package com.tendersai.demo.repository.Interfaces;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tendersai.demo.entity.User;

public interface UserRepo extends JpaRepository<User, UUID> {
    
}
