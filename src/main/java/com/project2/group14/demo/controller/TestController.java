package com.project2.group14.demo.controller;

import com.project2.group14.demo.repository.ProductsRepository;
import com.project2.group14.demo.repository.UserRepository;
import com.project2.group14.demo.repository.WishlistsRepository;
import com.project2.group14.demo.service.*;
import com.project2.group14.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService; // Replace with your actual repository
    
    @GetMapping("/db")
    public List<User> getUserList() {
        return userService.getUserList();
    }
}
