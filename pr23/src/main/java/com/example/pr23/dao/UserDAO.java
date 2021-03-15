package com.example.pr23.dao;

import com.example.pr23.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserDAO extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
