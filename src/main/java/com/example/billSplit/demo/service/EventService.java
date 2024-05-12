package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.EventRepository;
import com.example.billSplit.demo.repository.UserAppRepository;
import com.example.billSplit.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface{
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserAppRepository userRepository;

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event addNewEvent(Event event) {
        if(event.getOrganizer() == null){
            throw new IllegalArgumentException("Missing organizer in your event");
        }

        return eventRepository.save(event);
    }

    @Override
    public void deleteEvent(Integer eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public Event addAssistant(Integer eventId, UserApp userApp){
        Optional<Event> optionalEvent = eventRepository.findById(eventId);
        Optional<UserApp> optionalUserApp = userRepository.findById(userApp.getId());

        if (optionalEvent.isPresent() && optionalUserApp.isPresent()) {
            Event event = optionalEvent.get();
            UserApp user = optionalUserApp.get();

            event.addAssistants(user);
            return eventRepository.save(event);
        } else {
            throw new IllegalArgumentException("The event or user does not exist");
        }
    }

}
