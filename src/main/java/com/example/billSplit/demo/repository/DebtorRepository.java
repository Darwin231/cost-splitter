package com.example.billSplit.demo.repository;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Debtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DebtorRepository extends JpaRepository<Debtor, Integer> {
    Debtor save(Debtor debtor);

}
