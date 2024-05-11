package com.example.billSplit.demo.controller;

import com.example.billSplit.demo.model.Debt;
import com.example.billSplit.demo.model.Event;
import com.example.billSplit.demo.model.UserApp;
import com.example.billSplit.demo.repository.DebtRepository;
import com.example.billSplit.demo.repository.EventRepository;
import com.example.billSplit.demo.repository.UserAppRepository;
import com.example.billSplit.demo.service.DebtServiceInterface;
import com.example.billSplit.demo.service.EventServiceInterface;
import com.example.billSplit.demo.service.UserAppServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
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
    private UserAppServiceInterface userAppServiceInterface;
    @Autowired
    private UserAppRepository userAppRepository;

    //Debt dependencies
    @Autowired
    private DebtServiceInterface debtServiceInterface;
    @Autowired
    private DebtRepository debtRepository;


    //Event controller
    @PostMapping("/event")
    public Event createEvent(@RequestBody Event event){
        return eventServiceInterface.addNewEvent(event);
    }

    @GetMapping("/event/events")
    public List<Event> getEvents(){
        return eventRepository.findAll();
    }

    @PatchMapping("/event/assistant/{eventId}")
    public Event addAssistant(@PathVariable Integer eventId, @RequestBody UserApp userApp){
        return eventServiceInterface.addAssistant(eventId, userApp);
    }

    @GetMapping("/event/{eventId}/assistants")
    public List<UserApp> getAllUserByEventId(@PathVariable Integer eventId){
        return eventRepository.findAssistantsByEventId(eventId);
    }

    @GetMapping("/event/{eventId}/organizer")
    public List<UserApp> getOrganizerIdByEventId(@PathVariable Integer eventId){
        return eventRepository.findOrganizerIdByEventId(eventId);
    }


    //User Controller
    @PostMapping("/user")
    public UserApp createUser(@RequestBody UserApp userApp){
        return userAppServiceInterface.addNewUser(userApp);
    }

    @GetMapping("/user/{userId}")
    public Optional<UserApp> getUser(@PathVariable Integer userId){
        return userAppRepository.findById(userId);
    }

    @GetMapping("/user")
    public Optional<List<UserApp>> getUsersByName(@RequestParam String name){
        return userAppRepository.findByName(name);
    }


    //Debt Controller
    @PostMapping("/debt")
    public Debt createDebt(@RequestBody Debt debt, Event event){
        return debtServiceInterface.addNewDebt(debt, event);
    }

    @GetMapping("/debt/{eventId}/events")
    public List<Debt> debtsByEvent(@PathVariable Integer eventId) {
        return debtRepository.findDebtByEvent(eventId);
    }

    @GetMapping("/debt/{userId}/debts")
    public List<Debt> debtsByUser(@PathVariable Integer userId) {
        return debtRepository.findAllDebtByUserId(userId);
    }

    @PostMapping("/debt/{debtId}/debtors")
    public void addDebtor(@PathVariable Integer debtId, @RequestBody UserApp userApp) {
        debtServiceInterface.addDebtor(debtId, userApp);
    }

    // establish the amount to the bill between assistants
    @GetMapping("/debt/{debtId}/amounts")
    public int amountToPay(@ PathVariable Integer debtId){
        Optional<Debt> debt = debtRepository.findById(debtId);
        int amount = (int) (debt.get().getExpense() / debt.get().getDebtors().size());

        return amount;
    }


    // do a payment
    @PutMapping("/debt/payed")
    public void pay(Integer debtId, Integer amount, Integer userId){
        debtServiceInterface.payed(debtId, amount, userId);
    }


}
