package com.zhanibek.tasktracker.service;

import com.zhanibek.tasktracker.model.Project;
import com.zhanibek.tasktracker.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Project> getProjects() {
        return projectRepository.findAll();
    }

    public Project getProjectById(Long id){
        return projectRepository.getProjectById(id);
    }

    public void saveProject(Project project){
        projectRepository.save(project);
    }

    public void deleteProjectById(Long id){
        projectRepository.deleteById(id);
    }



}
