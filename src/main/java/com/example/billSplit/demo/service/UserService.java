package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
}
