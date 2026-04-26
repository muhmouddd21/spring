package com.tendersai.demo.DTO;

import jakarta.validation.constraints.*;

public record TaskRequest(
    @NotBlank String title,
    @Size(max = 200) String description
    
) {
}