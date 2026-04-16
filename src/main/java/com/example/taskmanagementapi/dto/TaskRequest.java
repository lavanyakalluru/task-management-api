package com.example.taskmanagementapi.dto;
import lombok.*;

@Getter
@Setter
public class TaskRequest {

    private String title;
    private String description;
    private boolean completed;

    // getters and setters
}