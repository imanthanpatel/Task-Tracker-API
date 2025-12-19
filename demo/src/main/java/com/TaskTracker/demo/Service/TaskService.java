package com.TaskTracker.demo.Service;

import aj.org.objectweb.asm.commons.Remapper;
import com.TaskTracker.demo.DTO.TaskDTO;
import com.TaskTracker.demo.DTO.TaskStatusUpdateDTO;
import com.TaskTracker.demo.DTO.TaskTitleDTO;
import com.TaskTracker.demo.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    public Task addTask(Task task);

    public static List<TaskDTO> getAllTask() {
        return null;
    }


    public Optional<Task> updateStatus(long id, TaskStatusUpdateDTO dto);
    public Optional<Task> updateTitle(long id, TaskTitleDTO dto);
    public Task deleteTask(Long id);
    public List<Task> getTasksByStatus(String status)

    ;
}
