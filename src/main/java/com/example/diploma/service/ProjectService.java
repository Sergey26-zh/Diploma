package com.example.diploma.service;

import com.example.diploma.dto.ProjectDto;
import com.example.diploma.dto.ProjectMemberDto;
import com.example.diploma.entity.Project;
import com.example.diploma.entity.ProjectMember;
import com.example.diploma.entity.User;
import com.example.diploma.mapper.ProjectMapper;
import com.example.diploma.repository.ProjectMemberRepository;
import com.example.diploma.repository.ProjectRepository;
import com.example.diploma.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectMapper projectMapper;
    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;
    private final UserRepository userRepository;

    @Transactional
    public Project create(ProjectDto projectDTO, Long creatorUserId) {
        String uniqueCode;
        do {
            uniqueCode = UUID.randomUUID().toString();
        } while (projectRepository.existsByUniqueCode(uniqueCode));

        User creatorUser = userRepository.findById(creatorUserId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Project project = Project.builder()
                .name(projectDTO.getName())
                .description(projectDTO.getDescription())
                .uniqueCode(uniqueCode)
                .adminId(creatorUser.getId())
                .build();

        return projectRepository.save(project);
    }
}
