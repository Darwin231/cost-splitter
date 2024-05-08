package com.example.billSplit.demo.service;

import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EventService implements EventServiceInterface{
    @Autowired
    private EventRepository eventRepository;

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
    public HttpStatus addAssistant(Integer eventId, UserApp userApp){
        Optional<Event> event = eventRepository.findById(eventId);
        if(event.isPresent()){
            event.get().addAssistants(userApp);
            Event updatedEvent = eventRepository.save(event.get());
            return HttpStatus.OK;
        } else {
            throw new IllegalArgumentException("The event does not exists");
        }

    }

}
