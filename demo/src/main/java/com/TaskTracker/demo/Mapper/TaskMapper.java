package com.TaskTracker.demo.Mapper;

import com.TaskTracker.demo.DTO.TaskDTO;
import com.TaskTracker.demo.DTO.TaskStatusUpdateDTO;
import com.TaskTracker.demo.DTO.TaskTitleDTO;
import com.TaskTracker.demo.model.Task;
import org.hibernate.StaleStateException;


//
public class TaskMapper {
//    //Entity -> DTO
        public static TaskStatusUpdateDTO toStatusdto(Task task){
            TaskStatusUpdateDTO dto = new TaskStatusUpdateDTO();
            dto.setStatus(task.getStatus());
            return dto;
        }

        public static Task toStatusentity(TaskStatusUpdateDTO dto){
            Task task = new Task();
            task.setStatus(dto.getStatus());
            return task;
        }



                public static TaskTitleDTO totitledto(Task task){
                    TaskTitleDTO dto = new TaskTitleDTO();
                    dto.setTitle(task.getTitle());
                    return  dto;
                }

                public static Task totitleentity(TaskTitleDTO dto){
                    Task task = new Task();
                    task.setTitle(dto.getTitle());
                    return task;
                }

                public static TaskDTO todto(Task task){
                    TaskDTO dto = new TaskDTO();
                    dto.setId(task.getId());
                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    dto.setCreatedAt(task.getCreatedAt());
                    dto.setUpdatedAt(task.getUpdatedAt());
                    return dto;
                }






}
