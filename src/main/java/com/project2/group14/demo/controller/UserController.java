package com.project2.group14.demo.controller;

import com.project2.group14.demo.entity.User;
import com.project2.group14.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get a user by ID
    @GetMapping("/user")
    public Optional<User> getUserById(@RequestParam(value = "userID") Integer userID) {
        return userRepository.findById(userID);
    }

    // Create a new user
    @PostMapping("/users/create")
    public void createUser(@RequestParam(value = "name") String name,
                           @RequestParam(value = "email") String email,
                           @RequestParam(value = "password") String password) {

        User newUser = new User();
        newUser.setName(name);
        newUser.setEmail(email);
        newUser.setPassword(password); 
        newUser.setAdmin(false);
        userRepository.save(newUser);
    }

    // Update an existing user by ID
    @PatchMapping("/users/update")
    public void updateUser(@RequestParam(value = "userID") Integer userID,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "email", required = false) String email,
                           @RequestParam(value = "password", required = false) String password) {

        Optional<User> optionalUser = userRepository.findById(userID);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (name != null) {
                user.setName(name);
            }
            if (email != null) {
                user.setEmail(email);
            }
            if (password != null) {
                user.setPassword(password); 
            }
            userRepository.save(user);
        }
    }

    // Delete a user by ID
    @DeleteMapping("/users/remove")
    public void deleteUser(@RequestParam(value = "userID") Integer userID) {
        userRepository.deleteById(userID);
    }

    // Search for users by name 
    @GetMapping("/users/search")
    public List<User> searchUsersByName(@RequestParam(value = "name") String name) {
        return userRepository.findByNameContaining(name);
    }
}
