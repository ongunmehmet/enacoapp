package com.enaco.enacoapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="doctor")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Doctor  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int doctorId;
    private String fullname;
    private String depertman;
    @JsonIgnoreProperties("doctor")
    @OneToMany( mappedBy = "doctor",cascade =CascadeType.REFRESH , orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Patient> patients =new ArrayList<>();

    public Doctor(String fullname, String depertman, List<Patient> patients) {
        this.fullname = fullname;
        this.depertman = depertman;
        this.patients = patients;
    }
}
