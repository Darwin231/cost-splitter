package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;

import java.util.List;

public interface DebtServiceInterface{
    List<Debt> getAllDebts();

    Debt addNewDebt(Debt debt, Event event);

    void deleteDebt(Integer debtId);

    void addDebtor(Integer debtId, UserApp userApp);

    void payed(Integer debtId, Float amount, Integer user);

}
