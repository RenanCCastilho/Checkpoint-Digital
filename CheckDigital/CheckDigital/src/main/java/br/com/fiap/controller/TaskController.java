package br.com.fiap.controller;

import org.springframework.web.bind.annotation.*;

import br.com.fiap.model.Task;
import br.com.fiap.service.TaskService;

import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskService.getTaskById(taskId);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{taskId}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task task) {
        return taskService.updateTask(taskId, task);
    }

    @DeleteMapping("/{taskId}")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
    
    
}
