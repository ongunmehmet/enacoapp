package com.enaco.enacoapp.reporsitory;

import com.enaco.enacoapp.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
}
