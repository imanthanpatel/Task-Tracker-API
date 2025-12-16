package com.TaskTracker.demo.controller;

import com.TaskTracker.demo.Service.TaskService;
import com.TaskTracker.demo.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService service;
//    private Object ResponseEntity;

    @GetMapping()
    public List<Task> getAllTask(){
        return  service.getAllTask();
    }

    @PostMapping()
    public Task addTask(@RequestBody Task task){
        return service.addTask(task);
    }
    @PutMapping("/put/{id}")
    public ResponseEntity<Task> updatestatus(@PathVariable Long id,@RequestParam String Status){
        return service.updatetask(id, Status)
                .map(ResponseEntity::ok)
                .orElseThrow();
    }
    @DeleteMapping("/{id}")
    public Task delete(@PathVariable long id){
        return service.deleteTask(id);
    }
}
