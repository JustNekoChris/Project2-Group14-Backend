
package com.project2.group14.demo.controller;

import com.project2.group14.demo.entity.Wishlists;
import com.project2.group14.demo.repository.WishlistsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class WishlistControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WishlistsRepository wishlistsRepository;

    @Test
    void shouldReturnWishlistList() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/wishlist")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    void shouldReturnWishlistById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/wishlist/{id}", 1)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}
