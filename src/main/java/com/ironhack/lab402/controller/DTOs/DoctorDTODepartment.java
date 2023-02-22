package com.ironhack.lab402.controller.DTOs;


import jakarta.validation.constraints.NotNull;

public class DoctorDTODepartment {

    @NotNull(message = "Department needed")
    private String department;



    public DoctorDTODepartment(String department) {
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}
