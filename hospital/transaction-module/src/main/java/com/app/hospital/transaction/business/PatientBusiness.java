package com.app.hospital.transaction.business;

import com.app.hospital.data.domain.Patient;
import com.app.hospital.main.exception.InvalidObjectException;
import com.app.hospital.transaction.service.PatientService;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Business class for the Patient.
 */
@Component
public class PatientBusiness {

    /**
     * Service for the Patient.
     */
    private final PatientService patientService;

    /**
     * Constrecteur.
     *
     * @param patientService Service for the Patient.
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

        try {
            patientList = patientService.getAllPatientsDB();

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (patientList == null || patientList.isEmpty()) {
            return new ResponseEntity<>("No data was found in the Database.", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    /**
     * Method to get a Patient by its ID.
     *
     * @param id ID of the Patient to find.
     * @return Patient found by set ID.
     */
    public ResponseEntity<Object> getPatientById(final Long id) {
        Patient patient = null;

        try {
            patient = patientService.getPatientByIdDB(id);

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (patient == null) {
            String message = String.format("No Patient was found by the id: %s", id);
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(patient, HttpStatus.OK);
    }

    /**
     * Method to create a new Patient.
     *
     * @param newPatient Patient to create.
     * @return Created Patient.
     */
    public ResponseEntity<Object> createPatient(final Patient newPatient) {
        //el programa debería pararse si esto no se cumple
        Patient createdPatient = null;

        try {
            verifyValidPatient(newPatient, false);
            createdPatient = patientService.createPatientToDB(newPatient);

        } catch (InvalidObjectException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(createdPatient, HttpStatus.CREATED);
    }

    /**
     * Method to modify a Patient.
     *
     * @param toModifyPatient   Patient to modify.
     * @return  modified Patient.
     */
    public ResponseEntity<Object> modifyPatient(final Patient toModifyPatient) {
        Patient modifiedPatient = null;

        try {
            verifyValidPatient(toModifyPatient, true);
            modifiedPatient = patientService.modifyPatientToDB(toModifyPatient);

        } catch (InvalidObjectException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        } catch (Exception e){
            //TODO: ver como hacer mejor el errorHandling
            return new ResponseEntity<Object>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (modifiedPatient == null) {
            String message = String.format("No Patient was found by the id: %s", toModifyPatient.getId());
            return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(modifiedPatient, HttpStatus.OK);
    }

    /**
     * Method to delete a Patient by its Id.
     *
     * @param id    Id of the Patient to delete.
     * @return  Confirmation message.
     */
    public ResponseEntity<Object> deletePatient(final Long id) {
        Patient toDeletePatient = null;

        try {
            toDeletePatient = patientService.getPatientByIdDB(id);

            if (toDeletePatient == null) {
                String message = String.format("No Patient was found by the id: %s", id);
                return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
            }

            patientService.deletePatientFromDB(id);

        } catch (Exception e) {
            return new ResponseEntity<Object>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        String message = String.format("The patient with the id: %s, was deleted", id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    /**
     * Verify validity of Patient
     *
     * @param patient    Patient to validate.
     * @param validateId differentiate when it creates or modifies a Patient.
     */
    private void verifyValidPatient(final Patient patient, final boolean validateId) {
        validateField(patient.getName(), "name");
        validateField(patient.getSurname(), "surname");
        validateField(patient.getSickness(), "sickness");

        if (validateId) {
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

        //TODO: hacer que esto se devuelva vía el catch del método principal
        if (StringUtils.isBlank(field)) {
            String message = String.format("The field %s is mandatory.", nameField);
            throw new InvalidObjectException(message);
        }
//        } catch (IllegalArgumentException e) {
//            //TODO: mejorar. Poner el type del field
//            String message = String.format("The field %s is in a wrong format.", nameField);
//            throw new IllegalArgumentException(message);
//        }
    }
}
