package com.example.diploma.service;

import com.example.diploma.entity.StageProject;
import com.example.diploma.repository.StageProjectRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StageProjectService {
    private final StageProjectRepository stageProjectRepository;

    @Transactional
    public StageProject create(StageProject stageProject) {
        return stageProjectRepository.save(stageProject);
    }

    public StageProject update(Long id, StageProject updateStage) {
        StageProject stageProject = stageProjectRepository.getById(id);
        if (stageProject == null) {
            throw new RuntimeException("Stage is not exist");
        }

        stageProject.setName(updateStage.getName());
        return stageProject;
    }

    public void delete(Long id) {
        if (stageProjectRepository.existsById(id)) {
            stageProjectRepository.deleteById(id);
        } else {
            throw new RuntimeException("Stage is not exist");
        }
    }
}
