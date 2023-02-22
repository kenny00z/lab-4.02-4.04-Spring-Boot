package com.ironhack.lab402.controller.DTOs;

import com.ironhack.lab402.model.Doctor;

import java.util.Date;

public class PatientDTO {


    private String name;
    private Date birthDate;

    private Doctor admittedBy;


    public PatientDTO(String name, Date birthDate, Doctor admittedBy) {
        this.name = name;
        this.birthDate = birthDate;
        this.admittedBy = admittedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Doctor getAdmittedBy() {
        return admittedBy;
    }

    public void setAdmittedBy(Doctor admittedBy) {
        this.admittedBy = admittedBy;
    }
}
