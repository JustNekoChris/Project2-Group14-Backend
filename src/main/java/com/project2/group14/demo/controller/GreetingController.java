package com.project2.group14.demo.controller;



import com.project2.group14.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project2.group14.demo.service.*;
import com.project2.group14.demo.entity.*;
import java.util.*;

@RestController
public class GreetingController {
    

    @Autowired
    private UserService userService; 

    @Autowired
    private ProductsService ProductsService; 

    @Autowired
    private WishlistsService WishlistsService; 
    
    @GetMapping("/user")
    public List<User> getUserList() {
        return userService.getUserList();
    }

    @PostMapping("/user")
    public User saveUser(User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/user/{id}")
    public void deleteUserById(@PathVariable("id") Integer userId) {
        userService.deleteUserById(userId);
    }

    @GetMapping("/product")
    public List<Products> getProductsList() {
        return ProductsService.getProductsList();
    }

    @PostMapping("/product")
    public Products saveProduct(Products products) {
        return ProductsService.saveProducts(products);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductsById(@PathVariable("id") Integer productId) {
        ProductsService.deleteProductsById(productId);
    }

    @GetMapping("/wishlists")
    public List<Wishlists> getWishlistsList() {
        return WishlistsService.getWishlistsList();
    }

    @PostMapping("/wishlists")
    public Wishlists saveWishlists(Wishlists wishlists) {
        return WishlistsService.saveWishlists(wishlists);
    }

    @DeleteMapping("/wishlists/{id}")
    public void deleteWishlistsById(@PathVariable("id") Integer wishlistsId) {
        WishlistsService.deleteWishlistsById(wishlistsId);
    }
    

    
    }

   
   
//     @Configuration
// public class WebConfig implements WebMvcConfigurer {

//     @Override
//     public void addCorsMappings(CorsRegistry registry) {
//         registry.addMapping("/**").allowedOrigins("http://localhost:3000"); //allows React Native application running on http://localhost:3000 to communicate with Spring Boot backend running on http://localhost:8080
//     }
// }