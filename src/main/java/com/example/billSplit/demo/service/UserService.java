package com.example.billSplit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.SpringVersion;

public class UserService implements UserServiceInterface{
    @Autowired
    private UserServiceInterface userServiceInterface;
}
