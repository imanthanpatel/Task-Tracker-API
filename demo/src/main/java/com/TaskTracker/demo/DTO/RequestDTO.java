package com.TaskTracker.demo.DTO;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDTO {
    @NotBlank(message = "title recquire")
    private String title;
    @NotBlank(message = "todo,completed,pending")
    private String status;
    @NotBlank(message = "provide message")
    private String description;

}
