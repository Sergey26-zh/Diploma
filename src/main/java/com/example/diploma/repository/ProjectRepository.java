package com.example.diploma.repository;

import com.example.diploma.entity.Project;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
    boolean existsByUniqueCode(String code);
}