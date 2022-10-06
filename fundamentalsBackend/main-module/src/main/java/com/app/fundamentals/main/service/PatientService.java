package com.app.fundamentals.main.service;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.data.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PatientService {

    /**
     * Patient repository
     */
    private final PatientRepository patientRepository;

    /**
     * Constrecteur
     *
     * @param patientRepository     patient repository
     */
    public PatientService(final PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    /**
     * Method por adding a patient
     */
    public void addPatient() {
        //TODO: funciona lo de linkear módulos mediante el POM
        Patient patient = new Patient(1L, "Benito", "Pérez");

        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        patientList.add(new Patient(2L, "Carlos", "Buenafuente"));
        patientList.add(new Patient(3L, "Juan", "Pérez"));
        patientList.add(new Patient(4L, "Pepe", "Luis"));

        // TODO: funciona lo del patientRepository también
        patientRepository.saveAll(patientList);

        showPatients();
    }

    private void showPatients() {

        //Show in loop
        for(Patient patient : patientRepository.findAll()){
            System.out.println("By loop: " + patient);
        }

        //Show by id
        Optional<Patient> patientRepositoryById = patientRepository.findById(1L);
        //Optional.ofNullable(users.get(id)); También valdría
        Patient patient = patientRepositoryById.orElse(null);
        System.out.println("By id: " + patient);
    }
}
