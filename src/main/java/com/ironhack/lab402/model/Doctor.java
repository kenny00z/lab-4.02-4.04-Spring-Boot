package com.ironhack.lab402.model;

import com.ironhack.lab402.enums.DoctorStatus;
import jakarta.persistence.*;

@Entity
public class Doctor {

    @Id
    private Long id;
    private String department;

    private String name;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum('ON_CALL', 'ON', 'OFF')")
    private DoctorStatus doctorStatus;




    public Doctor() {
    }

    public Doctor(String department, String name, DoctorStatus doctorStatus) {
        this.department = department;
        this.name = name;
        this.doctorStatus = doctorStatus;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DoctorStatus getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(DoctorStatus doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
}
