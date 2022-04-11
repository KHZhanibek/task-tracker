package com.zhanibek.tasktracker.api;

import com.zhanibek.tasktracker.model.Task;
import com.zhanibek.tasktracker.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/project/{project_id}/task")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getTasksFromProject(Long projectId){
        return taskService.getTasksFromProject(projectId);
    }

    @GetMapping(value = "/{id}")
    public Task getTask(@PathVariable("id") Long id){
        return taskService.getTaskById(id);
    }

    @PostMapping
    public String createTask(Task task){
        taskService.saveTask(task);
        return "Successfully saved task";
    }

//    @PutMapping(value = "/{id}")
//    public String updateTask(@PathVariable(value = "id") Long id, Task task){
//        task.setId(id);
//        taskService.saveTask(task);
//        return "Successfully updated task";
//    }

    @DeleteMapping(value = "/{id}")
    public String deleteTask(@PathVariable(value = "id") Long id){
        taskService.deleteTaskById(id);
        return "Successfully deleted task";
    }

}
