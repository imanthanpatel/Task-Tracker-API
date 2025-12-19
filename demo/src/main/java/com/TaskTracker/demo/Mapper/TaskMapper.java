package com.TaskTracker.demo.Mapper;


import com.TaskTracker.demo.DTO.RequestDTO;

import com.TaskTracker.demo.DTO.ResponceDTO;
import com.TaskTracker.demo.DTO.UpdateDTO;
import com.TaskTracker.demo.model.Task;


//
public class TaskMapper {
//    //Entity -> DTO


        public static UpdateDTO toupdatedto(Task task){

            UpdateDTO dto = new UpdateDTO();
            dto.setStatus(task.getStatus());
            dto.setTitle(task.getTitle());
            return dto;
        }
                public static Task toupdateentity(UpdateDTO dto){
                    Task task = new Task();
                    task.setStatus(dto.getStatus());
                    task.setTitle(dto.getTitle());
                    return task;
                }



            public static ResponceDTO toresponcedto(Task task){
                    ResponceDTO dto = new ResponceDTO();
                    dto.setId(task.getId());
                    dto.setTitle(task.getTitle());
                    dto.setDescription(task.getDescription());
                    dto.setCreatedAt(task.getCreatedAt());
                    dto.setUpdatedAt(task.getUpdatedAt());
                    return dto;

            }







                            public static Task toentity(RequestDTO dto) {
                                        Task task = new Task();
                                        task.setTitle(dto.getTitle());
                                        task.setDescription(dto.getDescription());

                                        return task;
                    }
}
