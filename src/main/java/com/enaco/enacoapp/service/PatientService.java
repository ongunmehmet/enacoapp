package com.enaco.enacoapp.service;

import com.enaco.enacoapp.entity.Patient;

import java.util.List;

public interface PatientService {
    Patient addPatient(Patient patient);
    List<Patient> getAllPatiets();
    Patient deletePatient(int id);
    Patient updatePatient(Patient patient);

}
