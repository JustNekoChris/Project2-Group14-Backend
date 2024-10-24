package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.Wishlists;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistsRepository extends JpaRepository<Wishlists, Integer> {
  @Qeury("SELECT * FROM wishlists WHERE userID = :userID")
  List<Wishlists> findWishlistsByUserID(@Param("userID") Integer userID)
}
