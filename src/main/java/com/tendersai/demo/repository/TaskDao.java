package com.tendersai.demo.repository;

import java.sql.PreparedStatement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.tendersai.demo.entity.Task;
import com.tendersai.demo.mapper.TaskRowMapper;
import com.tendersai.demo.repository.Interfaces.TaskDaoInterface;
    
@Repository
public class TaskDao implements TaskDaoInterface {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    

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
    public boolean deleteById(long id) {
         
        int rows =jdbcTemplate.update("DELETE FROM tasks WHERE id = ?", id);
        return rows > 0;
    }

    @Override
    public List<Task> findAll() {
        return jdbcTemplate.query("SELECT * FROM tasks", new TaskRowMapper());
    }

    @Override
    public long save(Task task) {
        String sql = "INSERT INTO tasks (title, description, assignee_name, status, created_at) VALUES (?, ?, ?, ?, ?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
                PreparedStatement ps = connection.prepareStatement(sql, new String[]{"id"});
                
                ps.setString(1, task.getTitle());
                ps.setString(2, task.getDescription());
                ps.setString(3, task.getAssigneeName());
                ps.setString(4, task.getStatus());
                ps.setTimestamp(5,
                    task.getCreatedAt() != null
                        ? java.sql.Timestamp.valueOf(task.getCreatedAt())
                        : null
                );

            return ps;
        }, keyHolder);

        return keyHolder.getKey().longValue();

    }
    @Override
    public Task update(Task task) {
    int rows = jdbcTemplate.update(
        "UPDATE tasks SET title = :title, description = :description, assignee_name = :assignee_name, status = :status  WHERE id = :id",
        new MapSqlParameterSource()
            .addValue("title", task.getTitle())
            .addValue("description", task.getDescription())
            .addValue("assignee_name", task.getAssigneeName())
            .addValue("status", task.getStatus())
            .addValue("id", task.getId())

        
    );

    if (rows == 0) {
        throw new RuntimeException("Task not found with id " + task.getId());
    }
        return findById(task.getId());
    }

}
