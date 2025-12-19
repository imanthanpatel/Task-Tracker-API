package com.TaskTracker.demo.Service;


import com.TaskTracker.demo.DTO.RequestDTO;
import com.TaskTracker.demo.DTO.ResponceDTO;

import com.TaskTracker.demo.DTO.UpdateDTO;
import com.TaskTracker.demo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    Task addTask(RequestDTO dto);
    List<ResponceDTO> getAllTask();
    Optional<Task> updateStatus(long id, UpdateDTO dto);
    void deleteTask(Long id);
    List<Task> getTasksByStatus(String status);







}
