
package com.project2.group14.demo.controller;

import com.project2.group14.demo.repository.ProductsRepository;
import com.project2.group14.demo.repository.UserRepository;
import com.project2.group14.demo.repository.WishlistsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProductsRepository productsRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WishlistsRepository wishlistsRepository;

    @Test
    void shouldReturnTestEndpoint() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/test")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
