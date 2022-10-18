package com.app.fundamentals.data.repository;

import com.app.fundamentals.data.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//El Long, debe ir después, sino me pide como argumento en los métodos el Patient
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    //método custom para verificar que no hayan entries repetidos en la DB
    public Patient findByNameAndSurnameAndSickness(String name, String surname, String sickness);
}
