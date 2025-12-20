package com.TaskTracker.demo.Service.Implementation;


import com.TaskTracker.demo.DTO.RequestDTO;
import com.TaskTracker.demo.DTO.ResponceDTO;

import com.TaskTracker.demo.DTO.UpdateDTO;
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


    public Task addTask(RequestDTO dto) {
        Task task = TaskMapper.toentity(dto);
        task.setStatus("Pending");
        return repo.save(task);               // save entity
    }



    public List<ResponceDTO> getAllTask() {
        return repo.findAll()
                .stream()
                .map(TaskMapper::toresponcedto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Task> updateStatus(long id, UpdateDTO dto) {
        return repo.findById(id)
                .map(task -> {
                    task.setStatus(Optional.ofNullable(dto.getStatus())
                            .orElse("pending"));

                    return repo.save(task);
                });
    }






    public void deleteTask(Long id) {
        repo.deleteById(id);

    }


    public List<Task> getTasksByStatus(String status) {
        return repo.findByStatus(status);
    }
}
