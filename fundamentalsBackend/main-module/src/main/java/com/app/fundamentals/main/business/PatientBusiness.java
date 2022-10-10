package com.app.fundamentals.main.business;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.main.service.PatientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Business class for the Patient
 */
@Component
public class PatientBusiness {

    /**
     * Service for the Patient
     */
    private PatientService patientService;

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
    public ResponseEntity<Object> getAllPatients(){
        List<Patient> patientList = null;

        try{
            patientList = patientService.getAllPatientsDB();

        } catch (Exception e) {
            return new ResponseEntity<>("An error has ocurred while quering the Database.", HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if(patientList == null || patientList.isEmpty()) {
            return new ResponseEntity<>("No data was found.", HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }
}
