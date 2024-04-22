package com.example.billSplit.demo.model;
import com.example.billSplit.demo.Utils.Functions;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @OneToMany(mappedBy = "organizer")
    private List<Event> organizedEvents = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "event_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name="event_id")

    )
    private List<Event> assistedEvents = new ArrayList<Event>();

    public User(String name, String email) {
        setName(name);
        setEmail(email);
    }

    public User(String name, String email, List<Event> events) {
        setName(name);
        setEmail(email);
        setEvents(events);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
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

    public List<Event> getEvents() {
        return assistedEvents;
    }

    public void setEvents(List<Event> assistedEvents) {
        this.assistedEvents = assistedEvents;
    }
}
