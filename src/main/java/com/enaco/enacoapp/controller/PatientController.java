package com.enaco.enacoapp.controller;

import com.enaco.enacoapp.entity.Doctor;
import com.enaco.enacoapp.entity.Patient;
import com.enaco.enacoapp.service.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("Patient")
public class PatientController {
    private PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @RequestMapping("/getall")
    public List<Patient> getAllDoctors (){
        return patientService.getAllPatiets();
    }
    @PostMapping("/add")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);
    }
    @DeleteMapping("/delete")
    public  Patient deletePatient(@RequestParam int id){
        return patientService.deletePatient(id);
    }
    @PutMapping("/update")
    public  Patient updatePAtient(@RequestBody  Patient patient){
        return patientService.updatePatient(patient);
    }

}
