package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.DebtRepository;
import com.example.billSplit.demo.repository.UserAppRepository;
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
    private UserAppRepository userAppRepository;

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
    public void addDebtor(Integer debtId, UserApp userApp) {
        Optional<Debt> debt = debtRepository.findById(debtId);

        if (debt.isPresent()) {
            debt.get().addDebtor(userApp);
            debtRepository.save(debt.get());

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public void payed(Integer debtId, Integer amount, Integer userId) {
        Optional<Debt> debt = debtRepository.findById(debtId);
        Optional<UserApp> user = userAppRepository.findById(userId);

        if (debt.get().getExpense() > 0){
            debt.get().pay(amount, debt.get());

            int debtIndex = debt.get().getDebtors().indexOf(user.get());

            debt.get().setDebtors((List<UserApp>) debt.get().getDebtors().remove(debtIndex));
        }

        debtRepository.save(debt.get());
    }

}

