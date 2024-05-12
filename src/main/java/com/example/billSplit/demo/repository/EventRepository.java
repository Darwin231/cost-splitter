package com.example.billSplit.demo.repository;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;
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

    @Query("SELECT DISTINCT u FROM UserApp u JOIN u.assistedEvents e WHERE e = :event")
    List<UserApp> findAssistantsByEvent(@Param("event") Event event);

    @Query("SELECT DISTINCT u FROM UserApp u JOIN u.assistedEvents e WHERE e.id = :eventId")
    List<UserApp> findAssistantsByEventId(@Param("eventId") Integer eventId);

    @Query("SELECT DISTINCT u FROM UserApp u JOIN u.assistedEvents e WHERE e.title = :eventTitle")
    List<UserApp> findAssistantsByEventTitle(@Param("eventTitle") String eventTitle);

    @Query("SELECT DISTINCT e.organizer FROM Event e WHERE e.id = :eventId")
    List<UserApp> findOrganizerIdByEventId(@Param("eventId") Integer eventId);

}
