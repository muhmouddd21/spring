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
    public int getTaskCount() {
        return taskDao.count();
    }

    public List<TaskResponse> getAllTasks() {
        return taskDao.findAll().
        stream()
        .map(taskMapper)
        .toList();
    }


    public TaskResponse createTask(TaskRequest request) {

        Task task = new Task(
            request.title(),
            request.description(),
            request.assignee_name(),
            request.status(),
            LocalDateTime.now()
        );

  
        long id = taskDao.save(task);   
        task.setId(id);   
        return taskMapper.apply(task);
    }
 

    public boolean deleteById(long id) {
        return taskDao.deleteById(id);
    }

    public TaskResponse updateTask(long id,TaskRequest request) {
        Task task = new Task(
            request.title(),
            request.description(),
            request.assignee_name(),
            request.status(),
            LocalDateTime.now()
        );
         task.setId(id);
        taskDao.update(task);
        return taskMapper.apply(task);
    }

}
