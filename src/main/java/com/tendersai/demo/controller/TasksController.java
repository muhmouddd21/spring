package com.tendersai.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tendersai.demo.entity.Task;
import com.tendersai.demo.service.TaskService;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
public class TasksController {
    private final TaskService taskService;

    public TasksController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/tasks")
    public List<Task> getMethodName() {

        return this.taskService.getAllTasks();
    }
    
}
