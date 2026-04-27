package com.tendersai.demo.DTO;

import jakarta.validation.constraints.*;

public record TaskRequest(
    @NotBlank(message = "Product name is required") String title,
    @Size(max = 200, message = "Description must be at most 200 characters") String description,
    @NotBlank(message = "Assignee name is required") String assigneeName,
    @NotBlank(message = "Status is required") String status
    
) {
}