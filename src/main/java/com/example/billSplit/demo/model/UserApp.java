package com.example.billSplit.demo.model;
import com.example.billSplit.demo.Utils.Functions;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class UserApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "organizer")
    private List<Event> organizedEvents = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "event_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")
    )
    private List<Event> assistedEvents = new ArrayList<Event>();

    @Column(name = "user_balances")
    @OneToMany(mappedBy = "userApp")
    private List<Balance> balances = new ArrayList<>();

    public UserApp(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public UserApp() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        // email check
        if(Functions.isValidEmail(email)){
            this.email = email;
        } else {
            throw new IllegalArgumentException("Not a valid e-mail");
        }
    }

    public List<Event> getOrganizedEvents() {
        return organizedEvents;
    }

    public void setOrganizedEvents(List<Event> organizedEvents) {
        this.organizedEvents = organizedEvents;
    }

    public List<Event> getAssistedEvents() {
        return assistedEvents;
    }

    public void setAssistedEvents(List<Event> assistedEvents) {
        this.assistedEvents = assistedEvents;
    }

    public List<Balance> getBalances() {
        return balances;
    }

    public void setBalances(List<Balance> balances) {
        this.balances = balances;
    }
}
