package com.example.billSplit.demo.repository;
import com.example.billSplit.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<EventRepository, Integer> {
    Event save(Event event);
}
