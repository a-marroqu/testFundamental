package com.app.hospital.data.dto;

import com.app.hospital.data.dto.common.Contrato;
import com.app.hospital.data.dto.common.Departamento;
import com.app.hospital.data.dto.common.Genero;

public class CeladorDto extends EmpleadoDto {

    private Departamento departamento;

    public CeladorDto(String nombre, String apellido, int edad, Genero genero, Contrato contrato, double sueldo) {
        super(nombre, apellido, edad, genero, contrato, sueldo);
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

}
