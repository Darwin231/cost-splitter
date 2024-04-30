package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.repository.DebtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
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

    @Override
    public void addDebtor(Integer debtId, User user) {
        Optional<Debt> debt = debtRepository.findById(debtId);

        if (debt.isPresent()) {
            debt.get().addDebtor(user);
            debtRepository.save(debt.get());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }


    }
}

