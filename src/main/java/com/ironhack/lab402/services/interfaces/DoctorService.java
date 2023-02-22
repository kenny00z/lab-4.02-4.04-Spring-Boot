package com.ironhack.lab402.services.interfaces;

import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDTOStatus;
import com.ironhack.lab402.model.Doctor;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface DoctorService {

    public Doctor searchDoctorByEmployeeId(Long id);

    List<Doctor> searchDoctorByStatus(String doctorStatus);

    List<Doctor> searchDoctorByDepartment(String department);

    void updateStatusDoctor(Long id, DoctorDTOStatus doctorDTOStatus);

    void updateDoctorDepartment(Long id, DoctorDTODepartment doctorDTODepartment);
}
