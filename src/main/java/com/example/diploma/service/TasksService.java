package com.example.diploma.service;

import com.example.diploma.entity.Tasks;
import com.example.diploma.repository.TasksRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.stream.Task;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TasksService {
    private final TasksRepository tasksRepository;

    public Tasks create(Tasks tasks) {
        return tasks;
    }
}
