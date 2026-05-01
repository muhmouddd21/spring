package com.tendersai.demo.mapper;

import java.util.function.Function;
import org.springframework.stereotype.Component;


import com.tendersai.demo.DTO.TaskResponse;
import com.tendersai.demo.entity.Task;

@Component
public class TaskMapper implements Function<Task, TaskResponse> {

    @Override
    public TaskResponse apply(Task task) {
        return new TaskResponse(
            task.getId(),
            task.getTitle(),
            task.getDescription(),
            task.getAssigneeName(),
            task.getStatus(),
            task.getCreatedAt()
        );
    }
}