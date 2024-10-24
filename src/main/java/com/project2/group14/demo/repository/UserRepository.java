package com.project2.group14.demo.repository;

import com.project2.group14.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    // Methos to find users by name (case-sensitive)
    List<User> findByNameContaining(String name);
}