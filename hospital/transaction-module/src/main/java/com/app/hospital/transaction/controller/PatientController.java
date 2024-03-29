package com.app.hospital.transaction.controller;

import com.app.hospital.data.domain.Patient;
import com.app.hospital.transaction.business.PatientBusiness;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Controller for the patients
 */
@RestController
@RequestMapping("/patient")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
public class PatientController {

    //TODO: añadir logger

    /**
     * Class business for patient
     */
    private final PatientBusiness patientBusiness;

    /**
     * Constrecteur
     *
     * @param patientBusiness   business class for patient
     */
    public PatientController(PatientBusiness patientBusiness) {
        this.patientBusiness = patientBusiness;
    }

    /**
     * Method to get all patients
     */
    @GetMapping
    public ResponseEntity<Object> getAllPatients() {
        ResponseEntity<Object> patientList = patientBusiness.getAllPatients();
        //TODO: también podrías devolver solamente el objeto, pero esto crea una respuesta más "web"
        //TODO: en el response entity, en vez de object, poner el objeto
        //con headers, statusCode(OK) y statusValue (200)

        //ResponseEntity<Object> response = verifyStatus(patientList);
        return new ResponseEntity<>(patientList.getBody(), patientList.getStatusCode());
    }

    /**
     * Method to get a patient by its ID
     */
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getPatientById(@PathVariable("id") final Long id) {
        ResponseEntity<Object> patient = patientBusiness.getPatientById(id);
        return new ResponseEntity<>(patient.getBody(), patient.getStatusCode());
    }

    /**
     * Method to create a patient
     */
    @PostMapping
    public ResponseEntity<Object> postPatient(@RequestBody final Patient patient) {
        ResponseEntity<Object> createdPatient = patientBusiness.createPatient(patient);
        return new ResponseEntity<Object>(createdPatient.getBody(), createdPatient.getStatusCode());
    }

    /**
     * Modify a patient
     */
    @PutMapping
    public ResponseEntity<Object> modifyPatient(@RequestBody final Patient patient) {
        ResponseEntity<Object> modifiedPatient = patientBusiness.modifyPatient(patient);
        return new ResponseEntity<Object>(modifiedPatient.getBody(), modifiedPatient.getStatusCode());
    }

    /**
     * Delete a patient
     */
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deletePatient(@PathVariable("id") final Long id) {
        ResponseEntity<Object> deletedPatient = patientBusiness.deletePatient(id);
        return new ResponseEntity<Object>(deletedPatient.getBody(), deletedPatient.getStatusCode());
    }

    /**
     * Method to verify status code, but i dont think its needed. The stats is set on the business page.
     */
//    private ResponseEntity<Object> verifyStatus(ResponseEntity<Object> patientBusiness) {
//        ResponseEntity<Object> response;
//
//        switch(patientBusiness.getStatusCode()) {
//            case OK:
//                return  patientBusiness;
//            default:
//
//        }
//
//        return null;
//    }
}
