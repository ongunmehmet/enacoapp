package com.enaco.enacoapp.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="patient")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Patient  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int patientId;
    private String fullName;
    @JsonIgnoreProperties("patient")
    @ManyToOne()
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    public Patient(String fullName, Doctor doctor) {
        this.fullName = fullName;
        this.doctor = doctor;
    }
}
