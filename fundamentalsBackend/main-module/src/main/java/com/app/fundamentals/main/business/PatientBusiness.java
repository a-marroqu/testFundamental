package com.app.fundamentals.main.business;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.data.repository.PatientRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PatientBusiness {

    private PatientRepository patientRepository;

    public PatientBusiness(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAll(){
        return patientRepository.findAll();
    }
}
