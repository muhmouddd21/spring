package com.tendersai.demo.DTO;

public record RegisterRequest(
    String name,
    String email,
    String password
) {
} 
