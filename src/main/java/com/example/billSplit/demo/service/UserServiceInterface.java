package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> getAllUsers();

    User addNewUser(User user);

    void deleteUser(Integer userId);
}
