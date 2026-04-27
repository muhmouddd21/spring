package com.tendersai.demo.repository.Interfaces;

import java.util.List;

import com.tendersai.demo.entity.Task;

public interface TaskDaoInterface {
    Task findById(long id);
    List<Task> findAll();
    int save(Task task);
    int count();
    void deleteById(long id);
    
} 
