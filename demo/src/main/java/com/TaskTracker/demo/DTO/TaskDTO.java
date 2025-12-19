package com.TaskTracker.demo.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;


@Getter
@Setter
public class TaskDTO {

    private Long id;

    private String title;
    private String description;
    private String status; // Pending, In Progress, Completed



    private LocalDateTime createdAt;


    private LocalDateTime updatedAt;
}
