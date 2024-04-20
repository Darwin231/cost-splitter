package com.example.billSplit.demo.repository;

import com.example.billSplit.demo.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    Debt save(Debt debt);
}
