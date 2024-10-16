package com.project2.group14.demo.controller;

import java.util.List;
import com.project2.group14.demo.entity.Products;
import com.project2.group14.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsController {

    private final ProductsRepository productsRepository;

    // Constructor Injection
    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/items")
    public List<Products> getAllProducts(@RequestParam(value = "userID", defaultValue = "0") Integer userID) {
        // If userID is 0, return all products, otherwise filter by userID
        return productsRepository.findAll();
    }
}
