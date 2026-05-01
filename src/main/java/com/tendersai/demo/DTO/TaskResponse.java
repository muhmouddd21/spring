package com.tendersai.demo.DTO;

import java.time.LocalDateTime;

public  record TaskResponse(
    Long id,
    String title,
    String description,
    String assignee_name,
    String status,
    LocalDateTime createdAt
    
) {} 
    

