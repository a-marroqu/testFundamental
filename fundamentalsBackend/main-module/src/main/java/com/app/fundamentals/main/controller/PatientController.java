package com.app.fundamentals.main.controller;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.main.business.PatientBusiness;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Controller for the patients
 */
@RestController
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
    @GET()
    @Path("")
    public ResponseEntity<Object> getAllPatients() {
        ResponseEntity<Object> patientList = patientBusiness.getAllPatients();
        //TODO: también podrías devolver solamente el objeto, pero esto crea una respuesta más "web"
        //con headers, statusCode(OK) y statusValue (200)

        //ResponseEntity<Object> response = verifyStatus(patientList);
        return new ResponseEntity<>(patientList.getBody(), patientList.getStatusCode());
    }

    /**
     * Method to get a patient by its ID
     */
    @GET()
    @Path("/{id}")
    public ResponseEntity<Object> getPatientById(@PathParam("id") final String id) {
        ResponseEntity<Object> patient = patientBusiness.getPatientById(id);
        return new ResponseEntity<>(patient.getBody(), patient.getStatusCode());
    }

    /**
     * Method to create a patient
     */
    @PostMapping(value = "/patient")
    public ResponseEntity<Object> postPatient(@RequestBody final Patient patient) {
        ResponseEntity<Object> createdPatient = patientBusiness.createPatient(patient);
        return new ResponseEntity<Object>(createdPatient.getBody(), createdPatient.getStatusCode());
    }

    /**
     * Modify a patient
     */
    @PUT
    @Path("")
    public ResponseEntity<Patient> modifyPatient(final Patient patient) {
        return null;
    }

    /**
     * Delete a patient
     */
    @DELETE
    @Path("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathParam("id") final String id) {
        return null;
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
