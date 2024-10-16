package com.project2.group14.demo.service;

import com.project2.group14.demo.entity.Products;
import java.util.*;

public interface ProductInterface {
    // saves Products to database @PostMapping
    Products saveProducts(Products Products);

    // gets Products by Id @GetMapping
    Products getProductsById(Products Products);

    // deletes Products by Id @DeleteMapping
    void deleteProductsById(Integer ProductsId);

    List<Products> getProductsList();
    
} 