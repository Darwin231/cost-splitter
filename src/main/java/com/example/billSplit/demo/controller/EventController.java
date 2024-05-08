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
import org.springframework.http.HttpStatus;
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

    @PatchMapping("/event/assistant")
    public HttpStatus addAssistant(@PathVariable Integer eventId, @RequestBody UserApp userApp){
        return eventServiceInterface.addAssistant(eventId, userApp);
    }

    @GetMapping("/event/assistants/{event_id}")
    public List<UserApp> getAllUserByEventId(Event event){
        return eventRepository.findAssistantsByEventId(event.getId());
    }

    @GetMapping("/event/organizer/{event_id}")
    public List<UserApp> getOrganizerByEventId(@PathVariable Integer eventId){
        return eventRepository.findOrganizersByEventId(eventId);
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

    @GetMapping("/user/debts/events/{eventId}")
    public List<Debt> debtsByEvent(@PathVariable Integer eventId) {
        return debtRepository.findDebtByEvent(eventId);
    }

    @GetMapping("/user/debts/{eventId}")
    public List<Debt> debtsByUser(@PathVariable Integer userId) {
        return debtRepository.findAllDebtsByUser(userId);
    }

    @PutMapping("/debt")
    public void addDebtor(Integer debtId, UserApp userApp) {
        debtServiceInterface.addDebtor(debtId, userApp);
    }

    // establish the amount to the bill between assistants
    @GetMapping("/debt/amounts")
    public int amountToPay(Debt debt, List<UserApp> userApps){
        int amount = (int) (debt.getExpense() / debt.getDebtors().size());
        debt.setDebtors(userApps);
        return amount;
    }

    // do a payment
    @PutMapping("/debt/payed")
    public void pay(Integer debtId, Integer amount, Integer userId){
        debtServiceInterface.payed(debtId, amount, userId);
    }


}
