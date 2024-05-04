package com.example.billSplit.demo.repository;

import com.example.billSplit.demo.model.Debt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Integer> {
    List<Debt> findAll();

    @Query("SELECT d FROM Debt d WHERE d.event.id = :eventId")
    List<Debt> findDebtByEvent(@Param("eventId") Integer eventId);

    @Query("SELECT d FROM Debt d WHERE d.userApp.id = :userId")
    List<Debt> findAllDebtsByUser(@Param("userId") Integer userId);

}
