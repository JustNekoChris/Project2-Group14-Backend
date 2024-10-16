package com.project2.group14.demo.service;


import org.springframework.beans.factory.annotation.*;
import com.project2.group14.demo.entity.Wishlists;
import com.project2.group14.demo.repository.WishlistsRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class WishlistsService implements WishlistsInterface {
    @Autowired
    private WishlistsRepository WishlistsRepository;

    @Override
    public Wishlists saveWishlists(Wishlists Wishlists) {
        return WishlistsRepository.save(Wishlists);
    }

    @Override
    public Wishlists getWishlistsById(Wishlists Wishlists) {
        return WishlistsRepository.findById(Wishlists.getWishlistID()).get();
    }

    @Override 
    public void deleteWishlistsById(Integer WishlistsId) {
        WishlistsRepository.deleteById(WishlistsId);
    }

    @Override 
    public List<Wishlists> getWishlistsList() {
        return (List<Wishlists>) WishlistsRepository.findAll();
    }


}
