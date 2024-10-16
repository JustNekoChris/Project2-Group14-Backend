package com.project2.group14.demo.controller;



import com.project2.group14.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project2.group14.demo.service.*;
import com.project2.group14.demo.entity.*;
import java.util.*;

@RestController
public class UserController {
    

    @Autowired
    private UserService userService; 

   

   
    
    @GetMapping("/user")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @GetMapping("/user/{id}")
    public void getUserById(@PathVariable("id") Integer userId) {
        userService.getUserById(userId);
    }

    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Integer userId) {
        userService.deleteUserById(userId);
    }

    

    
    

    
    }

   
   
