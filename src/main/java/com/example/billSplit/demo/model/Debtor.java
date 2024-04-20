package com.example.billSplit.demo.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "debtor")
public class Debtor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private User user;
    @Column(name = "persons_to_pay")
    private List<User> personsToPay;
    @Column(name = "event")
    private Event event;
    @Column(name = "concept")
    private String concept;


    public Debtor(User user, List<User> personsToPay, Event event, String concept) {
        setUser(user);
        setPersonsToPay(personsToPay);
        setEvent(event);
        setConcept(concept);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getPersonsToPay() {
        return personsToPay;
    }

    public void setPersonsToPay(List<User> personsToPay) {
        this.personsToPay = personsToPay;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }
}
