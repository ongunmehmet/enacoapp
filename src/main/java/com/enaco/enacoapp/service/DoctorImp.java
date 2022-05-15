package com.enaco.enacoapp.service;

import com.enaco.enacoapp.entity.Doctor;
import com.enaco.enacoapp.reporsitory.DoctorRepository;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class DoctorImp implements DoctorService{
   private DoctorRepository doctorRepository;

    public DoctorImp(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    @Transactional
    public Doctor addDoctor(Doctor doctor) {

        return doctorRepository.save(doctor);
    }

    @Override
    @Transactional
    public Doctor deleteDoctor(int Id) {
        if(doctorRepository.findById(Id)==null)
            throw new IllegalArgumentException("Girdiğiniz Id de doctor bulunmamktadır.");
        Doctor deletedDoctor=doctorRepository.findById(Id).orElseThrow(()->new IllegalArgumentException());
        doctorRepository.deleteById(Id);
        return deletedDoctor;
    }

    @Override
    @Transactional
    public Doctor updateDoctor(Doctor doctor) {
        if(doctorRepository.findById(doctor.getDoctorId())==null)
            throw new IllegalArgumentException("Güncellemek istediğiniz doktor bulunmamaktadır.Lütfen bilgileri tekrar kontrol ediniz");
        Doctor updatedDoctor = doctorRepository.findById(doctor.getDoctorId()).orElseThrow(()-> new IllegalArgumentException());
        updatedDoctor.setFullname(doctor.getFullname());
        updatedDoctor.setDepertman(doctor.getDepertman());
        updatedDoctor.setPatients(doctor.getPatients());
        doctorRepository.save(updatedDoctor);
        return updatedDoctor;
    }

    @Override
    public Doctor findById(int Id) {
        if(doctorRepository.findById(Id)==null)
            throw new IllegalArgumentException("Girdiğiniz Id de doctor bulunmamktadır.");
        Doctor requestedDoctor=doctorRepository.findById(Id).orElseThrow(()->new IllegalArgumentException());

        return requestedDoctor;
    }
}
