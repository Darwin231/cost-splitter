package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Role;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.model.UserApp;

import java.util.List;

public interface UserAppServiceInterface {
    List<UserApp> getAllUsers();

    UserApp addNewUser(UserApp userApp);

    void deleteUser(Integer userId);

}
