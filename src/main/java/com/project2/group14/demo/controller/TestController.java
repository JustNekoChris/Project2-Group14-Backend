package com.project2.group14.demo.controller;

import com.project2.group14.demo.repository.ProductsRepository;
import com.project2.group14.demo.repository.UserRepository;
import com.project2.group14.demo.repository.WishlistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserRepository userRepository; // Replace with your actual repository
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private WishlistsRepository wishlistsRepository;

    @GetMapping("/db")
    public ResponseEntity<String> testDatabaseConnection() {
        try {
            long countUser = userRepository.count(); // Query database
            long countProducts = productsRepository.count();
            long countWishlists = wishlistsRepository.count();
            return new ResponseEntity<>("<h3> Database connection successful. <h3/>" +
                                        "User row count: " + countUser + "<br/>" +
                                        "Products row count: " + countProducts + "<br/>" +
                                        "Wishlists row count: " + countWishlists + "<br/>"
                                        , HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Database connection failed: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
