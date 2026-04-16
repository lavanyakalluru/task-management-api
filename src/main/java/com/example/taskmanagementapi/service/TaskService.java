package com.example.taskmanagementapi.service;

import com.example.taskmanagementapi.entity.Task;
import com.example.taskmanagementapi.dto.*;
import com.example.taskmanagementapi.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class TaskService {

    private final TaskRepository repo;

    public TaskService(TaskRepository repo) {
        this.repo = repo;
    }

    public List<TaskResponse> getAllTasks() {
        return repo.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }


    public Task getTaskById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Task createTask(TaskRequest request) {

        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        task.setCompleted(request.isCompleted());

        return repo.save(task);
    }
    public TaskResponse mapToResponse(Task task) {
        TaskResponse response = new TaskResponse();
        response.setId(task.getId());
        response.setTitle(task.getTitle());
        response.setDescription(task.getDescription());
        response.setCompleted(task.isCompleted());
        return response;
    }

    public Task updateTask(Long id, Task updatedTask) {
        Task task = repo.findById(id).orElseThrow();
        task.setTitle(updatedTask.getTitle());
        task.setDescription(updatedTask.getDescription());
        task.setCompleted(updatedTask.isCompleted());
        return repo.save(task);
    }

    public void deleteTask(Long id) {
        repo.deleteById(id);
    }
}