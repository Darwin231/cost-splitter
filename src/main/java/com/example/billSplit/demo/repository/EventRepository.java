package com.example.billSplit.demo.repository;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer> {

    List<Event> findAll();

    Optional<Event> findById(Integer eventId);

    @Query("SELECT DISTINCT u FROM User u JOIN u.assistedEvents e WHERE e = :event")
    List<User> findAssistantsByEvent(@Param("event") Event event);

    @Query("SELECT DISTINCT u FROM User u JOIN u.assistedEvents e WHERE e.id IN :eventIds")
    List<User> findAssistantsByEventIds(@Param("eventIds") Integer eventIds);

    @Query("SELECT DISTINCT u FROM User u JOIN u.assistedEvents e WHERE e.title = :eventTitle")
    List<User> findAssistantsByEventTitle(@Param("eventTitle") String eventTitle);

    @Query("SELECT DISTINCT e.organizer FROM Event e WHERE e.id IN :eventIds")
    List<User> findOrganizersByEventIds(@Param("eventIds") Integer eventIds);
}
