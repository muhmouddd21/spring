package com.tendersai.demo.DTO;

import java.time.LocalDateTime;

public  record TaskResponse(
    String id,
    String title,
    String assigneeName,
    String status,
    LocalDateTime createdAt
) {} 
    

