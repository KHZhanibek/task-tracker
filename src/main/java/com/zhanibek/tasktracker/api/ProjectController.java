package com.zhanibek.tasktracker.api;

import com.zhanibek.tasktracker.model.Project;
import com.zhanibek.tasktracker.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    ProjectController(ProjectService projectService){
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getProject(Model model){
        model.addAttribute("projects", projectService.getProjects()) ;
        return projectService.getProjects();
    }

    @GetMapping(value = "/{id}")
    public Project getProject(@PathVariable(value = "id") Long id){
        return projectService.getProjectById(id);
    }

    @PostMapping
    public String createProject(Project project){
        System.out.println(project.toString());
        projectService.saveProject(project);
        return "Successfully created";
    }

    @PutMapping(value = "{id}")
    public String updateProject(@PathVariable(value = "id") Long id, Project project){
        project.setId(id);
        projectService.saveProject(project);
        return "Successfully updated";
    }

    @DeleteMapping(value = "/{id}")
    public String deleteProject(@PathVariable(value = "id") Long id){
        projectService.deleteProjectById(id);
        return "Successfully deleted";
    }
}