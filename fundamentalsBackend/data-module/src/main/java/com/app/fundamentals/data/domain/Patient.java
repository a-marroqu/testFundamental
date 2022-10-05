package com.app.fundamentals.data.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    /**
     * Id of the patient
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "patient_id")
    private Long id;

    /**
     * Name of the patient
     */
    @Column(name = "patient_name")
    private String name;

    /**
     * Surname of the patient
     */
    @Column(name = "patient_surname")
    private String surname;

}
