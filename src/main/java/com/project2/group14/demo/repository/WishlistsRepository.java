package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.Wishlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WishlistsRepository extends JpaRepository<Wishlists, Integer> {
    @Query("SELECT w FROM Wishlists w WHERE w.userID = :userID")
    List<Wishlists> findWishlistsByUserID(@Param("userID") Integer userID);
}
