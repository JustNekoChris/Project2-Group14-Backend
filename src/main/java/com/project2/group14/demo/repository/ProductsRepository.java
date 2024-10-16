package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    
}