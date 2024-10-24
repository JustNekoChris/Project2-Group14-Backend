package com.project2.group14.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.project2.group14.demo.entity.Products;
import com.project2.group14.demo.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

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
    public void addProduct(@RequestParam(value = "name") String name,
                           @RequestParam(value = "price", required = false) Double price,
                           @RequestParam(value = "link", required = false) String link,
                           @RequestParam(value = "image_link", required = false) String image_link,
                           @RequestParam(value = "amount_wanted", required = false) Integer amount_wanted,
                           @RequestParam(value = "description", required = false) String description) {

        // Logic to insert into the database
        Products temp = new Products();
        temp.setName(name);
        temp.setPrice(price);
        temp.setLink(link);
        temp.setImage_link(image_link);
        temp.setAmount_wanted(Objects.requireNonNullElse(amount_wanted, 1));
        temp.setAmount_bought(0);
        temp.setDescription(description);
        temp.setBought(false);
        productsRepository.save(temp);
    }

    @DeleteMapping("/items/remove")
    public void removeProduct(@RequestParam(value = "productID")Integer productID) {
        productsRepository.deleteById(productID);
    }

    @GetMapping("/items/single")
    public Optional<Products> getProductByID(@RequestParam(value = "itemID")Integer itemID) {
        return productsRepository.findById(itemID);
    }

    @PatchMapping("/items/update")
    public void updateProduct(@RequestParam(value = "productID") Integer productID,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "price", required = false) Double price,
                              @RequestParam(value = "link", required = false) String link,
                              @RequestParam(value = "image_link", required = false) String image_link,
                              @RequestParam(value = "amount_wanted", required = false) Integer amount_wanted,
                              @RequestParam(value = "description", required = false) String description,
                              @RequestParam(value = "bought", required = false) Boolean bought) {
        Optional<Products> temp = productsRepository.findById(productID);
        if (temp.isPresent()) {
            if (name != null) {
                temp.get().setName(name);
            }
            if (price != null) {
                temp.get().setPrice(price);
            }
            if (link != null) {
                temp.get().setLink(link);
            }
            if (image_link != null) {
                temp.get().setImage_link(image_link);
            }
            if (amount_wanted != null) {
                temp.get().setAmount_wanted(amount_wanted);
            }
            if (description != null) {
                temp.get().setDescription(description);
            }
            if (bought != null) {
                temp.get().setBought(bought);
            }
            productsRepository.save(temp.get());
        }
    }

    @GetMapping("/items/search")
    public List<Products> getByIdAndName(@Param(value = "userID")Integer userID,
                                         @Param(value = "search_term") String search_term) {
        return productsRepository.findProductsByUserIdAndName(userID, search_term);
    }
}
