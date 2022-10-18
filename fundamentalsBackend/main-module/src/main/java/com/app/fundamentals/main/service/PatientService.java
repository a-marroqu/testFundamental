package com.app.fundamentals.main.service;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.data.repository.PatientRepository;
import com.app.fundamentals.main.exception.InvalidObjectException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//TODO: verify porque es component
@Component
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
        Patient patient = new Patient(1L, "Benito", "Pérez", "está fatal");

        List<Patient> patientList = new ArrayList<>();
        patientList.add(patient);
        patientList.add(new Patient(2L, "Carlos", "Buenafuente", "madre mía"));
        patientList.add(new Patient(3L, "Juan", "Pérez", "ahora el otro"));
        patientList.add(new Patient(4L, "Pepe", "Luis", "se lo dices tú o yo"));

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

    /**
     * Get all patients from DB.
     *
     * @return list with all the patients.
     */
    public List<Patient> getAllPatientsDB() {
        return new ArrayList<>(patientRepository.findAll());
    }

    /**
     * Returns found Patient by set ID.
     *
     * @param id    ID of the Patient to find.
     * @return  Patient found by set ID.
     */
    public Patient getPatientByIdDB(final String id) {
        Long idLong = Long.parseLong(id);
        return patientRepository.findById(idLong).orElse(null);
    }

    /**
     * Creates new Patient in the DB.
     *
     * @param patient   Patient to insert in the DB.
     * @return  Created patient.
     */
    public Patient createPatientToDB(final Patient patient) {
        Patient duplication = patientRepository.findByNameAndSurnameAndSickness(patient.getName(), patient.getSurname(), patient.getSickness());

        if(Objects.isNull(duplication)) {
            return patientRepository.saveAndFlush(patient);

        } else {
            throw new InvalidObjectException("There is already a Patient with that name, surname and sickness");
        }
    }
}
