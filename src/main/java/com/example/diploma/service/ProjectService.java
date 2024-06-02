package com.example.diploma.service;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.entity.Project;
import com.example.diploma.mapper.ProjectMapper;
import com.example.diploma.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
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

    public void delete(Long id) {
        if (projectRepository.existsById(id)) {
            projectRepository.deleteById(id);
        } else {
            throw new RuntimeException("Project is not exist");
        }

    }
}
