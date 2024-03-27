package com.example.diploma.repository;

import com.example.diploma.entity.ProjectMember;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectMemberRepository extends CrudRepository<ProjectMember, Long> {
}
