package com.project2.group14.demo.controller;

import com.project2.group14.demo.service.*;
import com.project2.group14.demo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class WishlistController {

    @Autowired
    private WishlistsService WishlistsService; 

    @GetMapping("/wishlists")
    public List<Wishlists> getWishlistsList() {
        return WishlistsService.getWishlistsList();
    }

    @GetMapping("/wishlists/id")
    public void getWishlistsById(Wishlists wishlists) {
        WishlistsService.getWishlistsById(wishlists);
    }


    @PostMapping("/wishlists")
    public Wishlists saveWishlists(Wishlists wishlists) {
        return WishlistsService.saveWishlists(wishlists);
    }

    @DeleteMapping("/wishlists/{id}")
    public void deleteWishlistsById(@PathVariable("id") Integer wishlistsId) {
        WishlistsService.deleteWishlistsById(wishlistsId);
    }
}
