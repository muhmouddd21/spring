package com.tendersai.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tendersai.demo.entity.Task;
import com.tendersai.demo.mapper.TaskRowMapper;
import com.tendersai.demo.repository.Interfaces.TaskDaoInterface;
    
@Repository
public class TaskDao implements TaskDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    // List<Task>  tasks = new ArrayList<>(Arrays.asList(
    //     new Task("Task 1", "Description of Task 1", "John Doe", "Open", java.time.LocalDateTime.now()),
    //     new Task("Task 2", "Description of Task 2", "Jane Smith", "In Progress", java.time.LocalDateTime.now()),
    //     new Task("Task 3", "Description of Task 3", "Bob Johnson", "Closed", java.time.LocalDateTime.now())
    // ));

    // public List<Task> findAll() {
    //     return tasks;
    // }

    // public void save(Task task) {
    //     tasks.add(task);
    // }

    @Override
    public Task findById(long id) {
        return jdbcTemplate.queryForObject("select id, title, description, assignee_name, status, created_at from tasks where id = ?",
        new TaskRowMapper(), id);
    }

    @Override
    public int count() {
        return jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tasks", Integer.class);
    }

    @Override
    public void deleteById(long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteById'");
    }

    @Override
    public List<Task> findAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findAll'");
    }

    @Override
    public int save(Task task) {
        return jdbcTemplate.update(
            "INSERT INTO tasks (title, description, assignee_name, status, created_at) VALUES (?, ?, ?, ?, ?)",
            task.getTitle(),
            task.getDescription(),
            task.getAssigneeName(),
            task.getStatus(),
            task.getCreatedAt() != null 
                ? java.sql.Timestamp.valueOf(task.getCreatedAt()) 
                : null
        );
    }

}
