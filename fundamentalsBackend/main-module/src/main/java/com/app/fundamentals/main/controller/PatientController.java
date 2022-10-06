package com.app.fundamentals.main.controller;

import com.app.fundamentals.data.domain.Patient;
import com.app.fundamentals.main.business.PatientBusiness;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.awt.*;
import java.util.List;

/**
 * Controller for the patients
 */
@Controller
@Path("/paciente")
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
    public List<Patient> getAllPatients() {
        return patientBusiness.getAll();
    }

}
