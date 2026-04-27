package com.tendersai.demo.DTO;

import java.time.LocalDateTime;

public  record TaskResponse(
    Long id,
    String title,
    String assigneeName,
    String status,
    LocalDateTime createdAt
) {} 
    

