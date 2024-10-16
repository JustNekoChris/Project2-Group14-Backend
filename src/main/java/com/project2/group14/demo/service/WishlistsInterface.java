package com.project2.group14.demo.service;

import com.project2.group14.demo.entity.Wishlists;
import java.util.*;

public interface WishlistsInterface {
    // saves Wishlists to database @PostMapping
    Wishlists saveWishlists(Wishlists Wishlists);

    // gets Wishlists by Id @GetMapping
    Wishlists getWishlistsById(Wishlists Wishlists);

    // deletes Wishlists by Id @DeleteMapping
    void deleteWishlistsById(Integer WishlistsId);

    List<Wishlists> getWishlistsList();
    
} 