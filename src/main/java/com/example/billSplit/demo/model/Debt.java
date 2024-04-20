package com.example.billSplit.demo.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity(name = "debt")
public class Debt {
    // debt generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "user")
    private User user;
    @Column(name = "expense")
    private float expense;
    @Column(name = "concept")
    private String concept;
    @Column(name = "event")
    private Event event;
    @Column(name = "debtors")
    private List<User> debtors;
    @Column(name = "payed_debtors")
    private List<User> payedDebtors;
    @Column(name = "payed_amount")
    private Integer payedAmount;


    public Debt(User user, float expense, String concept, Event event, List<User> debtors, List<User> payedDebtors, Integer payedAmount) {
        setUser(user);
        setExpense(expense);
        setConcept(concept);
        setEvent(event);
        setDebtors(debtors);
        setPayedDebtors(payedDebtors);
        setPayedAmount(payedAmount);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public String getConcept() {
        return concept;
    }

    public void setConcept(String concept) {
        this.concept = concept;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public List<User> getDebtors() {
        return debtors;
    }

    public void setDebtors(List<User> debtors) {
        this.debtors = debtors;
    }

    public List<User> getPayedDebtors() {
        return payedDebtors;
    }

    public void setPayedDebtors(List<User> payedDebtors) {
        this.payedDebtors = payedDebtors;
    }

    public Integer getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Integer payedAmount) {
        this.payedAmount = payedAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Debt)) return false;
        Debt debt = (Debt) o;
        return Float.compare(expense, debt.expense) == 0 && Objects.equals(user, debt.user) && Objects.equals(concept, debt.concept) && Objects.equals(event, debt.event) && Objects.equals(debtors, debt.debtors) && Objects.equals(payedDebtors, debt.payedDebtors) && Objects.equals(payedAmount, debt.payedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, expense, concept, event, debtors, payedDebtors, payedAmount);
    }
}
