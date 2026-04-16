package com.example.taskmanagementapi.controller;

import com.example.taskmanagementapi.entity.Task;
import com.example.taskmanagementapi.dto.*;
import com.example.taskmanagementapi.service.TaskService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public List<TaskResponse> getAllTasks() {
        return service.getAllTasks();  // ✅ only calling service
    }

    @GetMapping("/{id}")
    public TaskResponse getTask(@PathVariable Long id) {

        Task task = service.getTaskById(id);
        return service.mapToResponse(task);
    }

    @PostMapping
    public TaskResponse createTask(@RequestBody TaskRequest request) {

        Task task = service.createTask(request);
        return service.mapToResponse(task);
    }
    @PutMapping("/{id}")
    public Task updateTask(@PathVariable Long id, @RequestBody Task task) {
        return service.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        service.deleteTask(id);
    }
}