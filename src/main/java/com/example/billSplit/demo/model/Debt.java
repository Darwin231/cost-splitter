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
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

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
            joinColumns = @JoinColumn(name = "debt_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<UserApp> debtors;

    @Column(name = "payed_amount")
    private Integer payedAmount;

    public Debt(UserApp userApp, float expense, String concept, Event event, List<UserApp> debtors, Integer payedAmount) {
        setUser(userApp);
        setExpense(expense);
        setConcept(concept);
        setEvent(event);
        setDebtors(debtors);
        setPayedAmount(payedAmount);
    }

    public Debt() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserApp getUser() {
        return userApp;
    }

    public void setUser(UserApp userApp) {
        this.userApp = userApp;
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

    public List<UserApp> getDebtors() {
        return debtors;
    }

    public void addDebtor(UserApp userApp){
        debtors.add(userApp);
    }

    public void setDebtors(List<UserApp> debtors) {
        this.debtors = debtors;
    }

    public Integer getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(Integer payedAmount) {
        this.payedAmount = payedAmount;
    }

    // Once a paid has been received
    public void pay(Integer payed, Debt debt){
        debt.setPayedAmount(payed);
        debt.setExpense(debt.getExpense() - payed);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Debt)) return false;
        Debt debt = (Debt) o;
        return Float.compare(expense, debt.expense) == 0 && Objects.equals(userApp, debt.userApp) && Objects.equals(concept, debt.concept) && Objects.equals(event, debt.event) && Objects.equals(debtors, debt.debtors) && Objects.equals(payedAmount, debt.payedAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userApp, expense, concept, event, debtors, payedAmount);
    }
}
