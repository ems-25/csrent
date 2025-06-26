package com.csrent.Dto;

import jakarta.persistence.Entity;

import java.time.LocalDate;


public class ReservationDto
{
    private String emailUser;
    private Integer idSpace;
    private LocalDate date;
    private String status;


    // /////////////////////////constructor sin parametros/////////////////
    public ReservationDto() {
    }

    // //////////////////////////////////////////////////////////////////////


    // ////////////////////////constructor con parametros/////////////////

    public ReservationDto(String emailUser, Integer idSpace, LocalDate date, String status) {
        this.emailUser = emailUser;
        this.idSpace = idSpace;
        this.date = date;
        this.status = status;
    }

    // //////////////////////////////////////////////////////////////////////


    // ///////////////////////GETTER Y SETTER/////////////////

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }

    public Integer getIdSpace() {
        return idSpace;
    }

    public void setIdSpace(Integer idSpace) {
        this.idSpace = idSpace;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate fecha) {
        this.date = fecha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}//fin de la clase