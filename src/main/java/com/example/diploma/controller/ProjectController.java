package com.example.diploma.controller;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.entity.Project;
import com.example.diploma.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/create")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public ResponseEntity<Project> createProject(@Valid @RequestBody ProjectDto projectDto, @PathVariable("id") long userId) {
        Project createdProject = projectService.create(projectDto, userId);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }
}
