package com.example.taskmanagementapi.dto;
import lombok.*;

@Getter
@Setter
public class TaskResponse {

    private Long id;
    private String title;
    private String description;
    private boolean completed;


    // getters and setters
}