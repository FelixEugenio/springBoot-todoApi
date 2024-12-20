package com.mavila.task_app.services;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mavila.task_app.models.User;
import com.mavila.task_app.repositories.UserRepository;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /* 
    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    */

    public User findById(Long id){
            Optional<User> user = this.userRepository.findById(id);
            return user.orElseThrow(()-> new RuntimeException("User not found! Id: " + id + " Tipo: " + User.class.getName()));
    }

    @Transactional
    public User create(User obj){
        //obj.setId(id:null);
        obj = this.userRepository.save(obj);
        
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj = this.findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    public void delete(Long id){
        findById(id);
        try{
            this.userRepository.deleteById(id);
        }catch(Exception e){
            throw new RuntimeException("User not found! Id: " + id + " Tipo: " + User.class.getName());
        }
    }
}
