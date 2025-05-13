package com.example.TaskManagement.Service;

import com.example.TaskManagement.Model.Task;
import com.example.TaskManagement.Repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    // create task method
     public Task create(Task task){
         return taskRepository.save(task);
     }

     // get all task
    public List<Task> getALlTask(){
         return taskRepository.findAll();
    }

    // get task by id
    public Optional<Task> getTaskById(Long id){
         return taskRepository.findById(id);
    }

    // update task
    public Task updateTask(Long id, Task taskDetails){
         Task task = taskRepository.findById(id).orElseThrow(()->new RuntimeException("task not found"));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setStatus(taskDetails.getStatus());
        return taskRepository.save(task);
    }

    // delete a task
    public void deleteTask(Long id){
         Task task = taskRepository.findById(id).orElseThrow(()-> new RuntimeException("not found"));
          taskRepository.delete(task);
    }


}
