package com.TaskTracker.demo.Service.Implementation;

import com.TaskTracker.demo.DTO.TaskDTO;
import com.TaskTracker.demo.DTO.TaskStatusUpdateDTO;
import com.TaskTracker.demo.DTO.TaskTitleDTO;
import com.TaskTracker.demo.Mapper.TaskMapper;
import com.TaskTracker.demo.Service.TaskService;
import com.TaskTracker.demo.model.Task;
import com.TaskTracker.demo.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ServiceIMP implements TaskService {

    private final TaskRepo repo;

    public ServiceIMP(TaskRepo repo) {
        this.repo = repo;
    }

    @Override
    public Task addTask(Task task) {
        task.setStatus("Pending");
        return repo.save(task);
    }

    public List<TaskDTO> getAllTask() {
        return repo.findAll()
                .stream()
                .map(TaskMapper::todto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> updateStatus(long id, TaskStatusUpdateDTO dto) {
        return repo.findById(id)
                .map(task -> {
                    task.setStatus(dto.getStatus());
                    return repo.save(task);
                });
    }

    @Override
    public Optional<Task> updateTitle(long id, TaskTitleDTO dto) {
        return repo.findById(id)
                .map(task -> {
                    task.setTitle(dto.getTitle());
                    return repo.save(task);
                });
    }

    @Override
    public Task deleteTask(Long id) {
        repo.deleteById(id);
        return null;
    }

    @Override
    public List<Task> getTasksByStatus(String status) {
        return repo.findByStatus(status);
    }
}
