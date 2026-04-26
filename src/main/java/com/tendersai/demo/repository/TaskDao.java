package com.tendersai.demo.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tendersai.demo.entity.Task;

@Repository
public class TaskDao {
    List<Task>  tasks = new ArrayList<>(Arrays.asList(
        new Task("Task 1", "Description of Task 1", "John Doe", "Open", java.time.LocalDateTime.now()),
        new Task("Task 2", "Description of Task 2", "Jane Smith", "In Progress", java.time.LocalDateTime.now()),
        new Task("Task 3", "Description of Task 3", "Bob Johnson", "Closed", java.time.LocalDateTime.now())
    ));

    public List<Task> findAll() {
        return tasks;
    }

    public void save(Task task) {
        tasks.add(task);
    }

}
