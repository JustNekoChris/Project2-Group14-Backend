package com.project2.group14.demo.controller;

import com.project2.group14.demo.entity.Wishlists;
import com.project2.group14.demo.repository.WishlistsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/wishlist")
public class WishlistController {

    @Autowired
    private WishlistsRepository wishlistsRepository;

    // Get all wishlists
    @GetMapping("/all")
    public List<Wishlists> getAllWishlists() {
        return wishlistsRepository.findAll();
    }

    // Get a single wishlist by ID
    @GetMapping("/single")
    public ResponseEntity<Wishlists> getWishlistById(@RequestParam(value = "wishlistID") Integer wishlistID) {
        Optional<Wishlists> wishlist = wishlistsRepository.findById(wishlistID);
        return wishlist.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Get all wishlists by user ID
    @GetMapping("/user")
    public List<Wishlists> getWishlistsByUserId(@RequestParam(value = "userID") Integer userID) {
        return wishlistsRepository.findWishlistsByUserID(userID);
    }

    // Create a new wishlist
    @PostMapping("/create")
    public ResponseEntity<Wishlists> createWishlist(@RequestParam(value = "userID") Integer userID,
                                                    @RequestParam(value = "wishlistName") String wishlistName) {
        Wishlists newWishlist = new Wishlists();
        newWishlist.setUserID(userID);
        newWishlist.setWishlistName(wishlistName);

        // Save the new wishlist to the repository
        Wishlists savedWishlist = wishlistsRepository.save(newWishlist);

        // Return the saved wishlist as JSON response
        return new ResponseEntity<>(savedWishlist, HttpStatus.CREATED);
    }


    // Update an existing wishlist
    @PatchMapping("/update")
    public ResponseEntity<String> updateWishlist(@RequestParam(value = "wishlistID") Integer wishlistID,
                                                 @RequestParam(value = "wishlistName", required = false) String wishlistName) {
        Optional<Wishlists> wishlist = wishlistsRepository.findById(wishlistID);
        if (wishlist.isPresent()) {
            if (wishlistName != null) {
                wishlist.get().setWishlistName(wishlistName);
            }
            wishlistsRepository.save(wishlist.get());
            return new ResponseEntity<>("Wishlist updated successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wishlist not found!", HttpStatus.NOT_FOUND);
        }
    }

    // Delete a wishlist by ID
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteWishlist(@RequestParam(value = "wishlistID") Integer wishlistID) {
        if (wishlistsRepository.existsById(wishlistID)) {
            wishlistsRepository.deleteById(wishlistID);
            return new ResponseEntity<>("Wishlist deleted successfully!", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Wishlist not found!", HttpStatus.NOT_FOUND);
        }
    }
}
