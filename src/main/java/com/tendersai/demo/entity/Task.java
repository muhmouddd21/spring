package com.tendersai.demo.entity;

import java.time.LocalDateTime;


public class Task {
    private Long id;
    private String title;
    private String description;
    private String assignee_name;
    private String status;
    private java.time.LocalDateTime createdAt;

    public Task() {
    }
    public Task(String title, String description, String assignee_name, String status, LocalDateTime createdAt) {
        this.title = title;
        this.description = description;
        this.assignee_name = assignee_name;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAssigneeName() {
        return assignee_name;
    }
    public void setAssigneeName(String assignee_name) {
        this.assignee_name = assignee_name;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public java.time.LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public void setCreatedAt(java.time.LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }


}
