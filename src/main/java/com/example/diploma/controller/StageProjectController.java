package com.example.diploma.controller;

import com.example.diploma.entity.StageProject;
import com.example.diploma.service.StageProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stage")
@RequiredArgsConstructor
public class StageProjectController {
    private final StageProjectService service;

    @PostMapping("/create")
    public StageProject create(@RequestBody StageProject stageProject) {
        return service.create(stageProject);
    }

    @DeleteMapping("/delete")
    public void delete(Long id) {
        service.delete(id);
    }
}
