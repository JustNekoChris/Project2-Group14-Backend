package com.project2.group14.demo.service;


import org.springframework.beans.factory.annotation.*;
import com.project2.group14.demo.entity.Products;
import com.project2.group14.demo.repository.ProductsRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ProductsService implements ProductsInterface {
    @Autowired
    private ProductsRepository ProductsRepository;

    @Override
    public Products saveProducts(Products Products) {
        return ProductsRepository.save(Products);
    }

    @Override
    public Products getProductsById(Products Products) {
        return ProductsRepository.findById(Products.getProductID()).get();
    }

    @Override 
    public void deleteProductsById(Integer ProductsId) {
        ProductsRepository.deleteById(ProductsId);
    }

    @Override 
    public List<Products> getProductsList() {
        return (List<Products>) ProductsRepository.findAll();
    }


}