package com.example.diploma.controller;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.service.ProjectService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping("/create")
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto, Principal principal) {
        String user = principal.getName();
        ProjectDto createdProject = projectService.create(projectDto);
        Long userId = Long.parseLong(user);
        createdProject.setUserId(userId);
        return new ResponseEntity<>(createdProject, HttpStatus.CREATED);
    }


}
