package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface EventServiceInterface {
    List<Event> getAllEvents();

    Event addNewEvent(Event event);

    void deleteEvent(Integer eventId);

    HttpStatus addAssistant(Integer eventId, UserApp userApp);

}
