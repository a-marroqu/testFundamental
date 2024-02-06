package com.app.hospital.data.dto;

import com.app.hospital.data.domain.Patient;
import com.app.hospital.data.dto.common.Contrato;
import com.app.hospital.data.dto.common.Genero;

import java.util.ArrayList;

public class FisioterapeutaDto extends EmpleadoDto {

    private ArrayList<Patient> pacientes;

    public FisioterapeutaDto(String nombre, String apellido, int edad, Genero genero, Contrato contrato, double sueldo) {
        super(nombre, apellido, edad, genero, contrato, sueldo);
    }

}
