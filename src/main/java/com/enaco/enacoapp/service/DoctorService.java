package com.enaco.enacoapp.service;

import com.enaco.enacoapp.entity.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getAllDoctors();
    Doctor addDoctor(Doctor doctor);
    Doctor deleteDoctor(int Id);
    Doctor updateDoctor(Doctor doctor);
    Doctor findById(int Id);
}