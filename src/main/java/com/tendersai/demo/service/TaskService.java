package com.tendersai.demo.service;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.tendersai.demo.DTO.TaskRequest;
import com.tendersai.demo.DTO.TaskResponse;
import com.tendersai.demo.entity.Task;
import com.tendersai.demo.mapper.TaskMapper;
import com.tendersai.demo.repository.TaskDao;

@Service
public class TaskService {
    private final TaskDao taskDao;
    private final TaskMapper taskMapper;


    public TaskService(TaskDao taskDao, TaskMapper taskMapper) {
        this.taskDao = taskDao;
        this.taskMapper = taskMapper;

    }

    public List<TaskResponse> getAllTasks() {
        return taskDao.findAll()
                .stream()
                    .map(taskMapper::apply)
                .toList();
    }


public TaskResponse createTask(TaskRequest request) {

    Task task = new Task(
        request.title(),
        request.description(),
        null,
        "NEW",
        LocalDateTime.now()
    );

    taskDao.save(task);
    return taskMapper.apply(task);
}
}
