package com.example.billSplit.demo.service;

import com.example.billSplit.demo.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DebtService implements DebtorServiceInterface{
    @Autowired
    private DebtRepository debtRepository;

}