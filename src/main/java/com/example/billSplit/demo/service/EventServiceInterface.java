package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;

import java.util.List;

public interface EventServiceInterface {
    List<Event> getAllEvents();

    Event addNewEvent(Event event);

    void deleteEvent(Integer eventId);

    Event addAssistant(Integer eventId, UserApp userApp);

}
