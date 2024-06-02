package com.example.diploma.repository;

import com.example.diploma.entity.StageProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StageProjectRepository extends CrudRepository<StageProject, Long> {
    StageProject getById(Long id);
}
