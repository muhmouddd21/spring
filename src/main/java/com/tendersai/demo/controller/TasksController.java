package com.tendersai.demo.controller;

import org.springframework.web.bind.annotation.RestController;

import com.tendersai.demo.DTO.TaskRequest;
import com.tendersai.demo.DTO.TaskResponse;
import com.tendersai.demo.service.TaskService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




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
    @GetMapping("/tasks/count")
    public int getMethodName() {
        return this.taskService.getTaskCount();
    }
    

    @PostMapping("/tasks")
    public TaskResponse create(@Valid @RequestBody TaskRequest entity) {
        return this.taskService.createTask(entity);
    }

    @DeleteMapping("/tasks/{id}")
    public boolean delete(@PathVariable long id) {
        return this.taskService.deleteById(id);
    }
    @PutMapping("/tasks/{id}")
    public TaskResponse putMethodName(@PathVariable long id, @Valid @RequestBody TaskRequest entity) {
        return this.taskService.updateTask(id,entity);
    }

}
