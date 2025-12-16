package main.java.com.TaskTracker.demo.model;


import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class task {
    private long id;

    private String description;
    private String Status;
    private String CreatedAt;
    private String UpdatedAt;
}
