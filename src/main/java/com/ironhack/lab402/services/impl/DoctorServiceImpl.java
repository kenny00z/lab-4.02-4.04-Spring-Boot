package com.ironhack.lab402.services.impl;

import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDTOStatus;
import com.ironhack.lab402.enums.DoctorStatus;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.repository.DoctorRepository;
import com.ironhack.lab402.services.interfaces.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    public Doctor searchDoctorByEmployeeId(Long id){

        Optional<Doctor> optionalDoctor = doctorRepository.findById(id);
        if(!optionalDoctor.isPresent()){
            throw new IllegalArgumentException("Doc is not found");
        }
        Doctor doctorDB = optionalDoctor.get();
        return doctorRepository.save(doctorDB);
    }


    public List<Doctor> searchDoctorByStatus(String doctorStatus) {
        DoctorStatus doctorStatusEnum = DoctorStatus.valueOf(doctorStatus.toUpperCase());

        return doctorRepository.findByStatus(doctorStatusEnum);
    }

    public List<Doctor> searchDoctorByDepartment(String department) {

        return doctorRepository.findByDepartment(department);
    }


    public void updateStatusDoctor(Long id, DoctorDTOStatus doctorDTOStatus) {
        Doctor doctorDB = doctorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doc is not found"));
        doctorDB.setDoctorStatus(doctorDTOStatus.getDoctorStatus());
    }


    public void updateDoctorDepartment(Long id, DoctorDTODepartment doctorDTODepartment) {
        Doctor doctorDB = doctorRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Doc is not found"));
        doctorDB.setDepartment(doctorDTODepartment.getDepartment());
        doctorRepository.save(doctorDB);
    }


}
