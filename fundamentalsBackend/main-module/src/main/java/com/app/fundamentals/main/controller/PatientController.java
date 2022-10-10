package com.app.fundamentals.main.controller;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.main.business.PatientBusiness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Controller for the patients
 */
@Controller
@Path("/patient")
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
        verifyStatus(patientList.getStatusCode());
        return new ResponseEntity<>(patientList, HttpStatus.OK);
    }

    /**
     * Method to get a patient by its ID
     */
    @GET()
    @Path("/{id}")
    public ResponseEntity<Patient> getPatientById(@PathParam("id") final String id) {

    }

    /**
     * Create a patient
     */
    @POST
    @Path("")
    public ResponseEntity<Patient> postPatient(final Patient patient) {

    }

    /**
     * Modify a patient
     */
    @PUT
    @Path("")
    public ResponseEntity<Patient> modifyPatient(final Patient patient) {

    }

    /**
     * Delete a patient
     */
    @DELETE
    @Path("/{id}")
    public ResponseEntity<Patient> deletePatient(@PathParam("id") final String id) {

    }


    private void verifyStatus(HttpStatus statusCode) {

    }
}
