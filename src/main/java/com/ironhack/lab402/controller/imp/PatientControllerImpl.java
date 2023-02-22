package com.ironhack.lab402.controller.imp;

import com.ironhack.lab402.controller.DTOs.PatientDTO;
import com.ironhack.lab402.controller.interfaces.PatientController;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.model.Patient;
import com.ironhack.lab402.repository.PatientRepository;
import com.ironhack.lab402.services.interfaces.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PatientControllerImpl implements PatientController {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PatientService patientService;

    @GetMapping("/patients")
    @ResponseStatus(HttpStatus.OK)
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient getPatientById(@PathVariable Long id) { return patientService.searchPatientById(id);}


    @PostMapping("/patients/add-patient")
    @ResponseStatus(HttpStatus.CREATED)
    public Patient addNewPatient(@RequestBody Patient patient){
        return patientRepository.save(patient);
    }


    @PutMapping("/patients/update-patient/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updatePatientInfo(@PathVariable Long id, @RequestBody @Valid PatientDTO patientDTO){
        patientService.updatePatientInfo(id, patientDTO);
    }


}
