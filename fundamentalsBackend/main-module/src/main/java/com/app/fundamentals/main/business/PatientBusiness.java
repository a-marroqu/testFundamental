package com.app.fundamentals.main.business;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.main.exception.InvalidObjectException;
import com.app.fundamentals.main.service.PatientService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.List;
import java.util.Objects;

/**
 * Business class for the Patient
 */
@Component
public class PatientBusiness {

    /**
     * Service for the Patient
     */
    private final PatientService patientService;

    /**
     * Constrecteur
     *
     * @param patientService    Service for the Patient
     */
    public PatientBusiness(final PatientService patientService) {
        this.patientService = patientService;
    }

    /**
     * Method to get all Patients from the repository.
     *
     * @return list of all the Patients
     */
    public ResponseEntity<Object> getAllPatients() {
        List<Patient> patientList = null;

        try{
            patientList = patientService.getAllPatientsDB();

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(patientList == null || patientList.isEmpty()) {
            return new ResponseEntity<>("No data was found in the Database.", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    /**
     * Method to get a Patient by its ID.
     *
     * @param id    ID of the Patient to find.
     * @return  Patient found by set ID.
     */
    public ResponseEntity<Object> getPatientById(final String id) {
        Patient patient = null;

        try{
            patient = patientService.getPatientByIdDB(id);

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(patient == null) {
            String message = String.format("No Patient was found by the id: %s", id);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    /**
     * Method to create a new Patient.
     *
     * @param newPatient    Patient to create
     * @return              Created Patient.
     */
    public ResponseEntity<Object> createPatient(final Patient newPatient) {
        //el programa debería pararse si esto no se cumple
        verifyValidPatient(newPatient, false);
        Patient createdPatient = null;

        try {
            createdPatient = patientService.createPatientToDB(newPatient);

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    /**
     * Verify validity of Patient
     *
     * @param patient       Patient to validate.
     * @param validateId    differentiate when it creates or modifies a Patient.
     */
    private void verifyValidPatient(final Patient patient, final boolean validateId) {
        validateField(patient.getName(), "name");
        validateField(patient.getSurname(), "surname");
        validateField(patient.getSickness(), "sickness");

        if(validateId){
            String id = Long.toString(patient.getId());
            validateField(id, "id");
        }
    }

    /**
     * Method to validate the Patients attributes
     *
     * @param field     attribut of a Patient
     * @param nameField name of the attribut
     */
    private void validateField(final String field, final String nameField) {
        try {
            if(StringUtils.isBlank(field)) {
                String message = String.format("The field %s is mandatory.", nameField);
                throw new InvalidObjectException(message);
            }

        } catch (IllegalArgumentException e) {
            //TODO: mejorar. Poner el type del field
            String message = String.format("The field %s is in a wrong format.", nameField);
            throw new IllegalArgumentException(message);
        }
    }
}
