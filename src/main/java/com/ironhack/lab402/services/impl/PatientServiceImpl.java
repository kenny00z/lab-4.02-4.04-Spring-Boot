package com.ironhack.lab402.services.impl;

import com.ironhack.lab402.controller.DTOs.PatientDTO;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class PatientServiceImpl {

    @Autowired
    PatientRepository patientRepository;

    public Patient searchPatientId(Long id){

        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if(!optionalPatient.isPresent()){
            throw new IllegalArgumentException("Patient is not found");
        }
        Patient patientDB = optionalPatient.get();
        return patientRepository.save(patientDB);
    }


    public void updatePatientInfo(Long id, PatientDTO patientDTO) {
        Patient patientDB = patientRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found"));
        if(patientDTO.getName() != null) patientDB.setName(patientDTO.getName());
        if(patientDTO.getBirthDate() != null) patientDB.setDateOfBirth(patientDTO.getBirthDate());
        if(patientDTO.getAdmittedBy() != null) patientDB.setAdmittedBy(patientDTO.getAdmittedBy());
        patientRepository.save(patientDB);
    }

}
