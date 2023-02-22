package com.ironhack.lab402.controller.imp;
import com.ironhack.lab402.controller.DTOs.DoctorDTODepartment;
import com.ironhack.lab402.controller.DTOs.DoctorDTOStatus;
import com.ironhack.lab402.controller.interfaces.DoctorController;
import com.ironhack.lab402.enums.DoctorStatus;
import com.ironhack.lab402.model.Doctor;
import com.ironhack.lab402.repository.DoctorRepository;
import com.ironhack.lab402.repository.PatientRepository;
import com.ironhack.lab402.services.impl.DoctorServiceImpl;
import com.ironhack.lab402.services.interfaces.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.List;
import java.util.Optional;

@RestController
public class DoctorControllerImpl implements DoctorController {
    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorService doctorService;



    @GetMapping("/doctors")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @GetMapping("/doctors/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Doctor getDoctorByEmployeeId(@PathVariable Long id) { return doctorService.searchDoctorByEmployeeId(id);}

    @GetMapping("/doctors/{status}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctorsByStatus(@PathVariable String doctorStatus){ return doctorService.searchDoctorByStatus(doctorStatus);}

    @GetMapping("/doctors/{department}")
    @ResponseStatus(HttpStatus.OK)
    public List<Doctor> getDoctorByDepartment(@PathVariable String department) {return doctorService.searchDoctorByDepartment(department);}



    @PostMapping("/doctors/add-doctor")
    @ResponseStatus(HttpStatus.CREATED)
    public Doctor addNewDoctor(@RequestBody @Valid Doctor doctor){
        return doctorRepository.save(doctor);
    }



    @PatchMapping("/doctors/update-status/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusDoctor(@PathVariable Long id, @RequestBody @Valid DoctorDTOStatus doctorDTOStatus){
        doctorService.updateStatusDoctor(id, doctorDTOStatus);
    }

    @PatchMapping ("/doctors/update-department/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateDoctorDepartment(@PathVariable Long id, @RequestBody @Valid DoctorDTODepartment doctorDTODepartment){
        doctorService.updateDoctorDepartment(id, doctorDTODepartment);
    }


}

