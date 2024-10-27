package com.project2.group14.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.project2.group14.demo.entity.Products;
import com.project2.group14.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class ProductsController {

    private final ProductsRepository productsRepository;

    // Constructor Injection
    @Autowired
    public ProductsController(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    @GetMapping("/items")
    public List<Products> getAllProducts() {
        return productsRepository.findAll();
    }
    @GetMapping("/items/user")
    public List<Products> getAllProductsByUserID(@RequestParam(value = "userID") Integer userID) {
        // If userID is 0, return all products, otherwise filter by userID
        return productsRepository.findProductsByUserId(userID);
    }

    @PostMapping("/items/create")
    public ResponseEntity<String> addProduct(@RequestParam(value = "wishlistID") Integer wishlistID,
                                             @RequestParam(value = "name") String name,
                                             @RequestParam(value = "price", required = false) Double price,
                                             @RequestParam(value = "link", required = false) String link,
                                             @RequestParam(value = "image_link", required = false) String image_link,
                                             @RequestParam(value = "amount_wanted", required = false) Integer amount_wanted,
                                             @RequestParam(value = "description", required = false) String description) {
        // Validate incoming data
        if (name == null || name.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Product name is required");
        }

        if (amount_wanted == null || amount_wanted < 1) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amount wanted must be at least 1");
        }

        // Logic to insert into the database
        try {
            Products temp = new Products();
            temp.setWishlistID(wishlistID);
            temp.setName(name);
            temp.setPrice(price);
            temp.setLink(link);
            temp.setImage_link(image_link);
            temp.setAmount_wanted(amount_wanted);
            temp.setAmount_bought(0);
            temp.setDescription(description);
            temp.setBought(false);

            // Save the product to the database
            productsRepository.save(temp);

            return ResponseEntity.status(HttpStatus.CREATED).body("Product created successfully");
        } catch (Exception e) {
            // Handle any exceptions that occur during saving
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error saving product: " + e.getMessage());
        }
    }


    @DeleteMapping("/items/remove")
    public void removeProduct(@RequestParam(value = "productID")Integer productID) {
        productsRepository.deleteById(productID);
    }

    @GetMapping("/items/single")
    public Optional<Products> getProductByID(@RequestParam(value = "itemID")Integer itemID) {
        return productsRepository.findById(itemID);
    }

    @GetMapping("/items/wishlist")
    public List<Products> getItemsByWishlistId(@RequestParam(value = "wishlistID") Integer wishlistID) {
        // Assuming the productsRepository has a method to find products by wishlist ID
        return productsRepository.findProductsByWishlistId(wishlistID);
    }

    @PutMapping("/items/update")
    public ResponseEntity<String> updateProduct(@RequestParam Integer productID,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false) Double price,
                                                @RequestParam(required = false) String link,
                                                @RequestParam(required = false) String image_link,
                                                @RequestParam(required = false) Integer amount_wanted,
                                                @RequestParam(required = false) String description,
                                                @RequestParam(required = false) Boolean bought) {

        Optional<Products> optionalProduct = productsRepository.findById(productID);

        if (optionalProduct.isPresent()) {
            Products product = optionalProduct.get();

            if (name != null) product.setName(name);
            if (price != null) product.setPrice(price);
            if (link != null) product.setLink(link);
            if (image_link != null) product.setImage_link(image_link);
            if (amount_wanted != null) product.setAmount_wanted(amount_wanted);
            if (description != null) product.setDescription(description);
            if (bought != null) product.setBought(bought);

            productsRepository.save(product);
            return ResponseEntity.ok("Product updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found.");
        }
    }

    @GetMapping("/items/search")
    public List<Products> getByIdAndName(@Param(value = "userID")Integer userID,
                                         @Param(value = "search_term") String search_term) {
        return productsRepository.findProductsByUserIdAndName(userID, search_term);
    }
}
