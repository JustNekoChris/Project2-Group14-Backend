package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    // Custom query to get products by userID through the wishlists table
    @Query("SELECT p " +
            "FROM Products p " +
            "JOIN Wishlists w ON p.wishlistID = w.wishlistID " +
            "WHERE w.userID = :userID")
    List<Products> findProductsByUserId(@Param("userID") Integer userID);

    @Query("SELECT p " +
            "FROM Products p " +
            "JOIN Wishlists w ON p.wishlistID = w.wishlistID " +
            "WHERE w.userID = :userID AND p.name LIKE CONCAT('%', :search_term, '%')")
    List<Products> findProductsByUserIdAndName(@Param("userID") Integer userID, @Param("search_term") String search_term);
}