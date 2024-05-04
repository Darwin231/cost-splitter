package com.example.billSplit.demo.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "organizer_id")
    private UserApp organizer;

    @Column(name = "location")
    private String location;

    @Column(name = "balance")
    private Float balance;

    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @ManyToMany(mappedBy = "assistedEvents")
    private List<UserApp> assistants;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Status status;

    @Column(name = "settled_up")
    private Boolean settledUp;

    public Event(String title, UserApp organizer, String location, Float balance, Date date, List<UserApp> assistants, Status status) {
        setTitle(title);
        setOrganizer(organizer);
        setLocation(location);
        setBalance(balance);
        setDate(date);
        setAssistants(assistants);
        setStatus(status);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public UserApp getOrganizer() {
        return organizer;
    }

    public void setOrganizer(UserApp organizer) {
        this.organizer = organizer;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<UserApp> getAssistants() {
        return assistants;
    }

    public void setAssistants(List<UserApp> assistants) {
        this.assistants = assistants;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    //To close de event
    public Boolean getSettledUp() {
        return settledUp;
    }

    public void setSettledUp(Boolean settledUp) {
        this.settledUp = settledUp;
    }
}
