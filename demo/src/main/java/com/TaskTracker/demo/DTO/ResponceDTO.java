package com.TaskTracker.demo.DTO;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;






@Getter
@Setter
public class ResponceDTO {


    private Long id;
    private String title;
    private String description;
    private String status; // Pending, In Progress, Completed
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
