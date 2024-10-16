package com.project2.group14.demo.service;

import com.project2.group14.demo.entity.User;
import java.util.*;

public interface UserInterface {
    // saves User to database @PostMapping
    User saveUser(User user);

    // gets user by Id @GetMapping
    User getUserById(User user);

    // deletes user by Id @DeleteMapping
    void deleteUserById(Integer userId);

    List<User> getUserList();
    
} 