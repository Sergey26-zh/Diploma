package com.example.diploma.controller;

import com.example.diploma.entity.Tasks;
import com.example.diploma.service.TasksService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@RequiredArgsConstructor
public class TasksController {
    private final TasksService tasksService;

    @PutMapping("/create")
    public Tasks create(Tasks tasks) {
        return tasksService.create(tasks);
    }
}
