package com.ironhack.lab402.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Date dateOfBirth;

    @ManyToOne
    @JoinColumn(name = "admitted_by")
    private Doctor doctor;

    public Patient() {
    }

    public Patient(String name, Date dateOfBirth, Doctor doctor) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.doctor = doctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }


    public void setAdmittedBy(Doctor admittedBy) {
    }
}

