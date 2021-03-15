package com.example.pr23.services;

import com.example.pr23.dao.UserDAO;
import com.example.pr23.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User getUser(String username) {
        return userDAO.findByUsername(username);
    }

    public void save(User user) {
        userDAO.save(user);
    }
}
