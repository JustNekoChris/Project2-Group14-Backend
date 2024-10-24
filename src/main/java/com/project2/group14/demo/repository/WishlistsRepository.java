package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.Wishlists;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface WishlistsRepository extends JpaRepository<Wishlists, Integer> {
    @Query("SELECT * FROM wishlists WHERE userID = :userID")
    List<Wishlists> findWishlistsByUserID(Integer userID);
}
