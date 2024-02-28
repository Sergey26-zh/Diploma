package com.example.diploma.service;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.entity.Project;
import com.example.diploma.mapper.ProjectMapper;
import com.example.diploma.repository.ProjectRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Cache;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.internal.SessionFactoryImpl;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectDto create(ProjectDto projectDto) {
        Project project = projectRepository.save(projectMapper.toEntity(projectDto));
        return projectMapper.toDto(project);
    }
}
