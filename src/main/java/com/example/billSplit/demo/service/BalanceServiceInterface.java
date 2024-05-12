package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Balance;
import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;

import java.util.List;

public interface BalanceServiceInterface {

    Balance addNewBalance(Debt debt, UserApp userApp, float amount);

}
