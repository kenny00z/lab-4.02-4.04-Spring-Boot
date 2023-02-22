package com.ironhack.lab402.repository;

import com.ironhack.lab402.enums.DoctorStatus;
import com.ironhack.lab402.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {


    public List<Doctor> findByStatus (DoctorStatus doctorStatus);

    public List<Doctor> findByDepartment (String department);


}
