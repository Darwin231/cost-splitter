package com.example.billSplit.demo.controller;

import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.User;
import com.example.billSplit.demo.repository.DebtRepository;
import com.example.billSplit.demo.repository.EventRepository;
import com.example.billSplit.demo.repository.UserRepository;
import com.example.billSplit.demo.service.DebtServiceInterface;
import com.example.billSplit.demo.service.EventServiceInterface;
import com.example.billSplit.demo.service.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EventController {
    //Event dependencies
    @Autowired
    private EventServiceInterface eventServiceInterface;
    @Autowired
    private EventRepository eventRepository;

    //User dependencies
    @Autowired
    private UserServiceInterface userServiceInterface;
    @Autowired
    private UserRepository userRepository;

    //Debt dependencies
    @Autowired
    private DebtServiceInterface debtServiceInterface;
    @Autowired
    private DebtRepository debtRepository;


    //Event controller
    @PostMapping("/event")
    public Event createEvent(@PathVariable Event event){
        return eventServiceInterface.addNewEvent(event);
    }

    @GetMapping("/event/assistants/{event_id}")
    public List<User> getAllUserByEventId(Event event){
        return eventRepository.findAssistantsByEventIds(event.getId());
    }

    @GetMapping("/event/organizer/{event_id}")
    public List<User> getOrganizerByEventId(@PathVariable Integer eventId){
        return eventRepository.findOrganizersByEventIds(eventId);
    }


    //User Controller
    @PostMapping("/user")
    public User createUser(@PathVariable User user){
        return userServiceInterface.addNewUser(user);
    }

    @GetMapping("/user/{userId}")
    public Optional<User> getUser(@PathVariable Integer userId){
        return userRepository.findById(userId);
    }



}
