package com.project2.group14.demo.controller;

import java.util.concurrent.atomic.AtomicLong;

import com.project2.group14.demo.entity.Greeting;
import com.project2.group14.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project2.group14.demo.service.*;
import com.project2.group14.demo.entity.*;
import java.util.*;

@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @Autowired
    private UserService userService; 
    
    @GetMapping("/db")
    public List<User> getUserList() {
        return userService.getUserList();
    }
    

    /*@GetMapping("/data") //dummy route
    public ResponseEntity<List<MyEntity>> getData() {
        List<MyEntity> data = // fetch data from the database
        return ResponseEntity.ok(data);
    }

    @PostMapping("/data")
    public ResponseEntity<MyEntity> createData(@RequestBody MyEntity entity) {
        MyEntity savedEntity = // save entity to the database
        return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
    }
        */
    
    }

   
   
//     @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**").allowedOrigins("http://localhost:3000"); //allows React Native application running on http://localhost:3000 to communicate with Spring Boot backend running on http://localhost:8080
//     }
// }