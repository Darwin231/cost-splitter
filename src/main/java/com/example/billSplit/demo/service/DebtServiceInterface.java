package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.User;

import java.util.List;

public interface DebtServiceInterface{
    List<Debt> getAllDebts();

    Debt addNewDebt(Debt debt);

    void deleteDebt(Integer debtId);

    void addDebtor(Integer debtId, User user);

    void payed(Integer debtId, Integer amount, Integer user);

}
