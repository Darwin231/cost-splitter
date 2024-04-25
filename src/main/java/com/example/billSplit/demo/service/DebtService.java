package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class DebtService implements DebtServiceInterface {
    @Autowired
    private DebtRepository debtRepository;


    @Override
    public List<Debt> getAllDebts() {
        return debtRepository.findAll();
    }

    @Override
    public Debt addNewDebt(Debt debt) {
        return debtRepository.save(debt);
    }

    @Override
    public void deleteDebt(Integer debtId) {
        debtRepository.deleteById(debtId);
    }

}

