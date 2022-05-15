package com.enaco.enacoapp.controller;

import com.enaco.enacoapp.entity.Doctor;
import com.enaco.enacoapp.service.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
   private DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @RequestMapping("/getall")
    public List<Doctor> getAllDoctors (){
        return doctorService.getAllDoctors();
    }
    @PostMapping("/add")
    public Doctor addDoctor(@RequestBody Doctor doctor){
        return doctorService.addDoctor(doctor);
    }
    @DeleteMapping("/delete")
    public  Doctor deleteDoctor(@RequestParam int id){
        return doctorService.deleteDoctor(id);
    }
    @PutMapping("/update")
    public  Doctor updateDoctor(@RequestBody  Doctor doctor){
        return doctorService.updateDoctor(doctor);
    }


}
