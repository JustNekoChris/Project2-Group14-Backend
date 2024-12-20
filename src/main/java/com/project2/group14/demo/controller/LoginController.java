package com.project2.group14.demo.controller;

import com.project2.group14.demo.entity.User;
import com.project2.group14.demo.repository.UserRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;
import java.util.HashMap;

@RestController
@RequestMapping("/login")
public class LoginController {

    private final UserRepository userRepository;

    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Login a user
    @PostMapping()
    public ResponseEntity<?> loginUser(@RequestBody Map<String, String> loginData) {
        String email = loginData.get("email");
        String password = loginData.get("password");

        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Email or password is missing.");
        }

        Optional<User> optionalUser = userRepository.findByEmail(email);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(BCrypt.hashpw(password, user.getSalt()))) {
                String jsonResponse = String.format("{\"userID\":\"%s\",\"name\":\"%s\"}", user.getUserID(), user.getName());
                return ResponseEntity.ok(jsonResponse);
            } else {
                return ResponseEntity.status(401).body("Invalid password.");
            }
        } else {
            return ResponseEntity.status(404).body("User not found.");
        }
    }

   @PostMapping("/admin")
   public ResponseEntity<Map<String, String>> adminLogin(@RequestBody Map<String, String> loginData) {
    String email = loginData.get("email");
    String password = loginData.get("password");

    Map<String, String> response = new HashMap<>();

    if (email == null || password == null) {
        response.put("error", "Email or password is missing.");
        return ResponseEntity.badRequest().body(response);
    }

    Optional<User> optionalUser = userRepository.findByEmail(email);

    if (optionalUser.isPresent()) {
        User user = optionalUser.get();
        
        if (!user.getAdmin()) {
            response.put("error", "Access denied. Admin privileges required.");
            return ResponseEntity.status(403).body(response);
        }
        
        if (user.getPassword().equals(BCrypt.hashpw(password, user.getSalt()))) {
            response.put("message", "Welcome Admin " + user.getName() + "!");
            return ResponseEntity.ok(response);
        } else {
            response.put("error", "Invalid password.");
            return ResponseEntity.status(401).body(response);
        }
    } else {
        response.put("error", "Admin user not found.");
        return ResponseEntity.status(404).body(response);
    }
  }
}
