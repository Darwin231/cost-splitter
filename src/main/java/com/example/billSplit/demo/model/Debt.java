package com.example.billSplit.demo.model;

import jakarta.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Debt")
public class Debt {
    // debt generation
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "expense")
    private float expense;

    @Column(name = "concept")
    private String concept;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToMany
    @JoinTable(
            name = "debt_debtors",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "debt_id")
    )
    private List<User> debtors;

    @Column(name = "payed_amount")
    private Integer payedAmount;

    public Debt(User user, float expense, String concept, Event event, List<User> debtors, Integer payedAmount) {
        setUser(user);
        setExpense(expense);
        setConcept(concept);
        setEvent(event);
        setDebtors(debtors);
        setPayedAmount(payedAmount);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void addDebtor(User user){
        debtors.add(user);
    }

    public void setDebtors(List<User> debtors) {
        this.debtors = debtors;
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
        return Float.compare(expense, debt.expense) == 0 && Objects.equals(user, debt.user) && Objects.equals(concept, debt.concept) && Objects.equals(event, debt.event) && Objects.equals(debtors, debt.debtors) && Objects.equals(payedAmount, debt.payedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, expense, concept, event, debtors, payedAmount);
    }
}
