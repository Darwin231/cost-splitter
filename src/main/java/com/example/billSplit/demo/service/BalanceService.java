package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Balance;
import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class BalanceService implements BalanceServiceInterface{
    @Autowired
    private BalanceRepository balanceRepository;

    @Override
    public Balance addNewBalance(Debt debt, UserApp userApp, float amount) {
        Balance balance = new Balance(userApp, debt, amount);
        return balanceRepository.save(balance);
    }

}
