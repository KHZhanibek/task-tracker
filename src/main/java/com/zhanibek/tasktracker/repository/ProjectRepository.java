package com.zhanibek.tasktracker.repository;

import com.zhanibek.tasktracker.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long>{
    Project getProjectById(Long id);
}

