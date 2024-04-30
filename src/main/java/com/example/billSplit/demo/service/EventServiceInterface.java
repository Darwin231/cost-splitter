package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface EventServiceInterface {
    List<Event> getAllEvents();

    Event addNewEvent(Event event);

    void deleteEvent(Integer eventId);

}
