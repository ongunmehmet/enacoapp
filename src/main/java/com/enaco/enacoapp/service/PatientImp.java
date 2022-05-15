package com.enaco.enacoapp.service;

import com.enaco.enacoapp.entity.Doctor;
import com.enaco.enacoapp.entity.Patient;
import com.enaco.enacoapp.reporsitory.DoctorRepository;
import com.enaco.enacoapp.reporsitory.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientImp  implements PatientService{
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;

    public PatientImp(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Patient addPatient(Patient patient) {
//        Doctor addedDoctor=doctorRepository.findById(patient.getDoctor().getDoctorId()).orElseThrow(()->new IllegalArgumentException("Seçtiğiniz doktor bulunmadı"));
//        patient.setDoctor(addedDoctor);


        return patientRepository.save(patient);
    }

    @Override
    public List<Patient> getAllPatiets() {
        return patientRepository.findAll();
    }

    @Override
    public Patient deletePatient(int id) {
        if(patientRepository.findById(id)==null)
            throw new IllegalArgumentException("Girdiğiniz id de hasta bulunmamktadır");
        Patient deletedPatient= patientRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
        patientRepository.deleteById(id);
        return deletedPatient;
    }

    @Override
    public Patient updatePatient(Patient patient) {
        if (patientRepository.findById(patient.getPatientId())==null)
            throw new IllegalArgumentException("Hasta id'si hatalı");
        Patient updatedPatient=patientRepository.findById(patient.getPatientId()).orElseThrow(()->new IllegalArgumentException());
        updatedPatient.setFullName(patient.getFullName());
        updatedPatient.setDoctor(patient.getDoctor());
        return patientRepository.save(updatedPatient);
    }
}
