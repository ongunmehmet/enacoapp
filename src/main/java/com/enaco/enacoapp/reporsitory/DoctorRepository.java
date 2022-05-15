package com.enaco.enacoapp.reporsitory;

import com.enaco.enacoapp.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
}
