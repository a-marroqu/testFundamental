package com.app.fundamentals.data.repository;

import com.app.fundamentals.data.domain.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//TODO: el Long, debe ir después, sino me pide como argumento en los métodos el Patient
@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
