package com.mavila.task_app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mavila.task_app.models.Task;
import com.mavila.task_app.models.User;
import com.mavila.task_app.repositories.TaskRepository;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserService userService;

    public Task findById(Long id) {
        Optional<Task> obj = this.taskRepository.findById(id);
        return obj.orElseThrow(()-> new RuntimeException("Task not found! Id: " + id + " Tipo: " + Task.class.getName()));
    }

    @Transactional
    public Task createTask(Task obj) {
        User user = this.userService.findById(obj.getUser().getId());
        obj.setUser(user);
        obj = this.taskRepository.save(obj);
        return obj;
    }

    @Transactional
    public Task updateTask(Task obj) {
        Task newObj = this.findById(obj.getId());
        newObj.setDescription(obj.getDescription());
        return this.taskRepository.save(newObj);
    }

    @Transactional
    public void deleteTask(Long id) {
        this.findById(id);
        try{
            this.taskRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("Task not found! Id: " + id + " Tipo: " + Task.class.getName());
        }
    }

    public List<Task> findByUser_Id(Long id) {
        List<Task> tasks = this.taskRepository.findByUser_Id(id);
        return tasks;
    }
}
