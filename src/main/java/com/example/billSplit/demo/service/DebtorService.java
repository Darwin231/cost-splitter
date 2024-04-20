package com.example.billSplit.demo.service;

import com.example.billSplit.demo.repository.DebtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DebtorService implements DebtorServiceInterface{
    @Autowired
    private DebtorRepository debtorRepository;

}
