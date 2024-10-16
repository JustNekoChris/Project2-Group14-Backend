package com.project2.group14.demo.service;


import org.springframework.beans.factory.annotation.*;
import com.project2.group14.demo.entity.User;
import com.project2.group14.demo.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class UserService implements UserInterface {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserById(User user) {
        return userRepository.findById(user.getUserID()).get();
    }

    @Override 
    public void deleteUserById(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override 
    public List<User> getUserList() {
        return (List<User>) userRepository.findAll();
    }


}
