package com.tendersai.demo.repository.Interfaces;

import java.util.List;

import com.tendersai.demo.entity.Task;

public interface TaskDaoInterface {
    Task findById(long id);
    List<Task> findAll();
    long save(Task task);
    int count();
    boolean deleteById(long id);
    Task update(Task task);
    
} 
