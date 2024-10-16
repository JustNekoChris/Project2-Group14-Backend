package com.project2.group14.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project2.group14.demo.entity.Products;
import com.project2.group14.demo.service.ProductsService;
import java.util.*;

@RestController
public class ProductController {
     @Autowired
    private ProductsService ProductsService; 

    @GetMapping("/product")
    public List<Products> getProductsList() {
        return ProductsService.getProductsList();
    }

    @GetMapping("/product/{id}")
    public void getProductsById(@PathVariable("id") Integer productsId) {
        ProductsService.getProductsById(productsId);
    }

    @PostMapping("/product")
    public Products saveProduct(Products products) {
        return ProductsService.saveProducts(products);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProductsById(@PathVariable("id") Integer productId) {
        ProductsService.deleteProductsById(productId);
    }
}
