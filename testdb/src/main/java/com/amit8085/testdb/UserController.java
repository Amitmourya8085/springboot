package com.amit8085.testdb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    UserService service;

    @GetMapping("/test")
    public String testService(){
        return "ok";
    }
    @PostMapping("/user")
    public User CreateUser(@RequestBody User user){
        return service.SaveUser(user);
    }
    @GetMapping("/users")
    public List<User> getUser(){
        return service.getAllUser();
    }
    @PutMapping("/user/{id}")
    public User UpdateUser(@PathVariable Long id,@RequestBody User user){
        return service.updateUser(id,user);
    }
   @DeleteMapping("user/rm/{id}")
    public String DeleteUser(@PathVariable Long id){
        return service.DeleteUser(id);
   }
   @GetMapping("/user/name/{name}")
    public List<User> getuser(@PathVariable String name ){
        return service.getUserByName(name);
   }
   @PatchMapping("/user/patch/{id}/name")
    public User updateName(@PathVariable Long id,String name){
        return service.UpdateName(id,name);
   }
   @GetMapping("/user/count")
    public Long userCount(){
        return service.CountUser();
   }
}
