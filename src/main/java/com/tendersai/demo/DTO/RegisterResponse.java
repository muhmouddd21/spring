package com.tendersai.demo.DTO;

import java.util.UUID;

public record RegisterResponse(
    UUID id,
    String name,
    String email,
    String message
) {
};
