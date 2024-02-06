package com.app.hospital.data.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "patients")
@NoArgsConstructor
@AllArgsConstructor
public class Patient implements Serializable {

    private static final long serialVersionUID = 4518011202924886996L;

    /**
     * Id of the patient
     */
    //TODO: posible cambiar luego la generationType
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    private Long id;

    /**
     * Name of the patient
     */
    @Column(name = "patient_name")
    @JsonProperty(required = true)
    private String name;

    /**
     * Surname of the patient
     */
    @Column(name = "patient_surname")
    @JsonProperty(required = true)
    private String surname;

    /**
     * Sickness of the patient
     */
    @Column(name = "patient_sickness")
    @JsonProperty(required = true)
    private String sickness;

    @OneToOne
    @JoinColumn(name = "doctor_cabecera_id")
    private Doctor doctorCabecera;

//    @ManyToMany
//    @JoinTable(
//            name = "patient_doctor",
//            joinColumns = @JoinColumn(name = "patient_id"),
//            inverseJoinColumns = @JoinColumn(name = "doctor_id")
//    )
//    private List<Doctor> otherDoctors;
}
