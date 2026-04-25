package com.tendersai.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tendersai.demo.entity.Task;

@Service
public class TaskService {
    List<Task>  tasks = new ArrayList<>(Arrays.asList(
        new Task("Task 1", "Description of Task 1"),
        new Task("Task 2", "Description of Task 2"),
        new Task("Task 3", "Description of Task 3")
    ));

    public List<Task> getAllTasks() {
        return tasks;
    }

}
