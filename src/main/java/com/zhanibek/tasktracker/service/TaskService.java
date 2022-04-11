package com.zhanibek.tasktracker.service;

import com.zhanibek.tasktracker.model.Project;
import com.zhanibek.tasktracker.model.Task;
import com.zhanibek.tasktracker.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTasksFromProject(Long projectId) {
        return taskRepository.getAllByProjectId(projectId);
    }

    public Task getTaskById(Long id){
        return taskRepository.getById(id);
    }

    public void saveTask(Task task){
        taskRepository.save(task);
    }

    public void deleteTaskById(Long id){
        taskRepository.deleteById(id);
    }
}
