package com.TaskTracker.demo.Service;

import com.TaskTracker.demo.model.Task;
import com.TaskTracker.demo.Repository.TaskRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepo repo;

    public TaskService(TaskRepo repo) {
        this.repo = repo;
    }

    public Task addTask(Task task) {
        task.setStatus("Pending");
        return repo.save(task);

    }

    public List<Task> getAllTask() {
        return repo.findAll();
    }
    public Optional<Task> updatetask(long id, String Status){
        return repo.findById(id).map(task ->
        {
            task.setStatus(Status);
            return repo.save(task);
        });
    }

    public Task deleteTask(Long id){
        repo.deleteById(id);
        return null;
    }
}
