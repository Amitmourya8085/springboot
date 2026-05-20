package com.amit8085.testdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepositary repo;

    public User SaveUser(User user){
        return repo.save(user);
    }

    public List<User> getAllUser(){
        return repo.findAll();
    }

    public User updateUser(Long id,User newUser){
        User oldUser=repo.findById(id).orElse(null);
        if(oldUser != null){
            oldUser.setName(newUser.getName());
            oldUser.setAge(newUser.getAge());
            return repo.save(oldUser) ;
        }
        return null;
    }

    public User FindbyidUser(Long id){
        return repo.findById(id).orElse(null);

    }

    public String DeleteUser(Long id){
        repo.deleteById(id);
        return "Deleted ...";

    }

     public List<User> getUserByName(String name){
        return repo.findByName(name);
    }

    public User UpdateName(Long id,String name){
        User user=repo.findById(id).orElse(null);
        if(user != null){
            user.setName(name);
            return repo.save(user);
        }
        return null;
    }


    public Long CountUser(){
        return repo.count();
    }
}
