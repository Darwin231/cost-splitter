package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.repository.DebtRepository;
import com.example.billSplit.demo.repository.UserRepository;
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
    @Autowired
    private UserRepository userRepository;

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


    @Override
    public void payed(Integer debtId, Integer amount, Integer userId) {
        Optional<Debt> debt = debtRepository.findById(debtId);
        Optional<User> user = userRepository.findById(userId);

        if (debt.get().getExpense() > 0){
            debt.get().pay(amount, debt.get());

            int debtIndex = debt.get().getDebtors().indexOf(user.get());

            debt.get().setDebtors((List<User>) debt.get().getDebtors().remove(debtIndex));
        }

        debtRepository.save(debt.get());
    }

}

