package com.TaskTracker.demo.controller;

import com.TaskTracker.demo.DTO.TaskDTO;
import com.TaskTracker.demo.DTO.TaskStatusUpdateDTO;
import com.TaskTracker.demo.DTO.TaskTitleDTO;
import com.TaskTracker.demo.Service.TaskService;
import com.TaskTracker.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }
//    private Object ResponseEntity;

    @GetMapping()
    public ResponseEntity<Task> getAllTask(){
        List<TaskDTO> task = TaskService.getAllTask();
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body((Task) task);

    }

    @PostMapping()
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }
    @PatchMapping("/updateststus{id}")
    public ResponseEntity<Task> updateStatus(
            @PathVariable Long id,
            @RequestBody TaskStatusUpdateDTO dto) {

        return service.updateStatus(id, dto.getStatus())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PatchMapping("/updatetitle/{id}")
    public ResponseEntity<Task> updateTitle(
            @PathVariable Long id,
            @RequestBody TaskTitleDTO dto){

        return service.updateTitle(id, dto.getTitle())
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }



    @DeleteMapping("/{id}")
    public Task delete(@PathVariable long id){
        return service.deleteTask(id);
    }
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable String status) {
        return service.getTasksByStatus(status);
    }
}
