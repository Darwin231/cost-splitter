package com.example.billSplit.demo.service;

import com.example.billSplit.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class EventService implements EventServiceInterface{
    @Autowired
    private EventRepository eventRepository;
}
