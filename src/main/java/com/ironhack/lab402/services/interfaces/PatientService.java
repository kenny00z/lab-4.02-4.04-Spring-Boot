package com.ironhack.lab402.services.interfaces;

import com.ironhack.lab402.controller.DTOs.PatientDTO;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;

public interface PatientService {


    public Patient searchPatientById(Long id);

    void updatePatientInfo(Long id, PatientDTO patientDTO);
}
