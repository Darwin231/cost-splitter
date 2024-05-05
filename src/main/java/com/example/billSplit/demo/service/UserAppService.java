package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Role;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.UserAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAppService implements UserAppServiceInterface {
    @Autowired
    private UserAppRepository userAppRepository;


    @Override
    public List<UserApp> getAllUsers() {
        return userAppRepository.findAll();
    }

    @Override
    public UserApp addNewUser(UserApp userApp) {
        return userAppRepository.save(userApp);
    }

    @Override
    public void deleteUser(Integer userId) {

        Optional<UserApp> user = userAppRepository.findById(userId);

        if(user.isPresent()){
            userAppRepository.deleteById(userId);
        } else {
            throw new IllegalArgumentException("User not found with ID: " + userId);
        }


    }


}
