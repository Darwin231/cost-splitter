package com.example.billSplit.demo.model;

import jakarta.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "Balance")
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserApp userApp;

    @ManyToOne
    @JoinColumn(name = "debt_id")
    private Debt debt;

    @Column(name = "amount_owed")
    private Float amountOwed;

    public Balance(UserApp userApp, Debt debt, float amountOwed) {
        setUserApp(userApp);
        setDebt(debt);
        setAmountOwed(amountOwed);
    }

    public Balance(){}


    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public Debt getDebt() {
        return debt;
    }

    public void setDebt(Debt debt) {
        this.debt = debt;
    }

    public Float getAmountOwed() {
        return amountOwed;
    }

    public float setAmountOwed(float amountOwed) {
        return this.amountOwed = amountOwed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Balance)) return false;
        Balance balance = (Balance) o;
        return Objects.equals(id, balance.id) && Objects.equals(userApp, balance.userApp) && Objects.equals(debt, balance.debt) && Objects.equals(amountOwed, balance.amountOwed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userApp, debt, amountOwed);
    }
}
