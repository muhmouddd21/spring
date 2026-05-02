package com.tendersai.demo.DTO;

import java.util.UUID;

public record LoginResponse(
    UUID id,
    String name,
    String email) {
} 
