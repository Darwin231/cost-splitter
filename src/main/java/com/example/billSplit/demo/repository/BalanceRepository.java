package com.example.billSplit.demo.repository;

import com.example.billSplit.demo.model.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer> {
    List<Balance> findAll();

    @Query("SELECT b FROM Balance b WHERE b.debt.id = :debtId")
    Optional<Balance> findBalanceByDebt(@Param("debtId") Long debtId);

    @Query("SELECT b FROM Balance b WHERE b.userApp.id = :userId")
    Optional<Balance> findAllBalanceByUserId(@Param("userId") Integer userId);

    @Query("SELECT b FROM Balance b WHERE b.userApp.id = :userId AND b.debt.id = :debtId")
    Optional<Balance> findBalanceByUserIdAndDebtId(@Param("userId") Integer userId, @Param("debtId") Integer debtId);


}
