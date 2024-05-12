package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Balance;
import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.BalanceRepository;
import com.example.billSplit.demo.repository.DebtRepository;
import com.example.billSplit.demo.repository.EventRepository;
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
    @Autowired
    private BalanceRepository balanceRepository;
    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Debt> getAllDebts() {
        return debtRepository.findAll();
    }

    @Override
    public Debt addNewDebt(Debt debt, Event event) {
        if(debt.getExpense() >= 0) {
            float amount = event.getBalance() + debt.getExpense();
            event.setBalance(amount);
            return debtRepository.save(debt);
        } else {throw new IllegalArgumentException("Debt cannot be 0");}
    }

    @Override
    public void deleteDebt(Integer debtId) {
        debtRepository.deleteById(debtId);
    }

    @Override
    public void addDebtor(Integer debtId, UserApp userApp) {
        Optional<Debt> debt = debtRepository.findById(debtId);

        if (debt.isPresent()) {
            float amount = debt.get().getExpense() + debt.get().getDebtors().size();
            debt.get().addDebtor(userApp);
            debtRepository.save(debt.get());

            Balance balance = new Balance(userApp, debt.get(), amount);
            balanceRepository.save(balance);

        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

    }


    @Override
    public void payed(Integer debtId, Float amount, Integer userId) {
        Optional<Debt> debt = debtRepository.findById(debtId);
        Optional<UserApp> user = userAppRepository.findById(userId);
        Optional<Balance> balance = balanceRepository.findBalanceByUserIdAndDebtId(userId, debtId);

        if(debt.isPresent() && user.isPresent() && balance.isPresent()){

            float amounts = debt.get().getExpense() / debt.get().getDebtors().size();

            if (debt.get().getExpense() > 0 && amount.equals(amounts)){
                debt.get().pay(amount, debt.get());

                int debtIndex = debt.get().getDebtors().indexOf(user.get());


                debt.get().getDebtors().remove(debtIndex);

                // paid amount in event
                Event event = debt.get().getEvent();
                event.setBalance(event.getBalance()- debt.get().getPayedAmount());
                balance.get().setAmountOwed(balance.get().getAmountOwed() - amount);



            } else if (debt.get().getExpense() > 0 && amount < amounts) {
                debt.get().pay(amount, debt.get());

                // paid amount in event
                Event event = debt.get().getEvent();
                event.setBalance(event.getBalance()- debt.get().getPayedAmount());
                balance.get().setAmountOwed(balance.get().getAmountOwed() - amount);

            }

        } else {
            throw new IllegalArgumentException("You cannot pay a non existing debt");
        }


        debtRepository.save(debt.get());
        balanceRepository.save(balance.get());
    }

}

