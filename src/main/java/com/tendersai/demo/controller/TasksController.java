package com.tendersai.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tendersai.demo.DTO.TaskRequest;
import com.tendersai.demo.DTO.TaskResponse;
import com.tendersai.demo.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class TasksController {
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<TaskResponse> getAll() {
        return this.taskService.getAllTasks();
    }
    @PostMapping("/tasks")
    public TaskResponse create(@Valid @RequestBody TaskRequest entity) {
        return this.taskService.createTask(entity);
    }
    
    
}
