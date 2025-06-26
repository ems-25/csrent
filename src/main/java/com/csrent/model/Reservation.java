package com.csrent.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Reservation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//esto es para que el valor que ingrese aumente atomaticamente de 1 en 1

    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "space_id", nullable = false)
    private Space space;
    private LocalDate dateReservation;
    private String status;


    public Reservation() {
    }

    public Reservation(Integer id, String status, LocalDate dateReservation, User user, Space space) {
        this.id = id;
        this.status = status;
        this.dateReservation = dateReservation;
        this.user = user;
        this.space = space;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(LocalDate dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Space getSpace() {
        return space;
    }

    public void setSpace(Space space) {
        this.space = space;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
