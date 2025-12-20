package com.TaskTracker.demo.controller;

import com.TaskTracker.demo.DTO.RequestDTO;
import com.TaskTracker.demo.DTO.ResponceDTO;
import com.TaskTracker.demo.DTO.UpdateDTO;
import com.TaskTracker.demo.Mapper.TaskMapper;
import com.TaskTracker.demo.Service.TaskService;
import com.TaskTracker.demo.model.Task;

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

    //  GET all tasks
    @GetMapping("/all")
    public ResponseEntity<List<ResponceDTO>> getAllTask() {
        List<ResponceDTO> tasks = service.getAllTask();
        return ResponseEntity.ok(tasks);
    }

    //  ADD task (REQUEST → ENTITY → RESPONSE)
    @PostMapping("/add")
    public ResponseEntity<ResponceDTO> addTask(@RequestBody RequestDTO dto) {
        Task createdTask = service.addTask(dto);
        ResponceDTO response = TaskMapper.toresponcedto(createdTask);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // UPDATE task
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponceDTO> updateStatus(
            @PathVariable Long id,
            @RequestBody UpdateDTO dto) {

        Task updatedTask = service.updateStatus(id, dto)
                .orElseThrow(() -> new RuntimeException("Task not found"));

        ResponceDTO response = TaskMapper.toresponcedto(updatedTask);

        return ResponseEntity.ok(response);
    }

    // ✅ DELETE task
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.deleteTask(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/status/{status}")
    public ResponseEntity<List<ResponceDTO>> getTasksByStatus(@PathVariable String status) {
        List<Task> tasks = service.getTasksByStatus(status);
        List<ResponceDTO> response = tasks.stream()
                .map(TaskMapper::toresponcedto)
                .toList();
        return ResponseEntity.ok(response);
    }
}
