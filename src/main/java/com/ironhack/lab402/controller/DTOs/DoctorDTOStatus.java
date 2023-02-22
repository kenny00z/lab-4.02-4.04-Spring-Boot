package com.ironhack.lab402.controller.DTOs;

import ch.qos.logback.core.status.Status;
import com.ironhack.lab402.enums.DoctorStatus;
import jakarta.validation.constraints.NotNull;

public class DoctorDTOStatus {

    @NotNull (message = "Status needed")
    private DoctorStatus doctorStatus;


    public DoctorDTOStatus(DoctorStatus doctorStatus) {
        this.doctorStatus = doctorStatus;
    }

    public DoctorStatus getDoctorStatus() {
        return doctorStatus;
    }
}
