package com.app.hospital.data.dto;

import com.app.hospital.data.domain.Patient;
import com.app.hospital.data.dto.common.Contrato;
import com.app.hospital.data.dto.common.Departamento;
import com.app.hospital.data.dto.common.Especialidad;
import com.app.hospital.data.dto.common.Genero;
import com.app.hospital.data.dto.common.NivelDoctor;

import java.time.LocalTime;
import java.util.ArrayList;

public class DoctorDto extends EmpleadoDto {

    private Especialidad    especialidad;

    private Departamento    departamento;

    private NivelDoctor     nivelDoctor;

    private ArrayList<Patient>   listaPacientes;

    private ArrayList<LocalTime> listaGuardias;

    private ArrayList<LocalTime> listaPeonadas;

    private ArrayList<LocalTime> listaConsulta;

    public DoctorDto(String nombre, String apellido, int edad, Genero genero, Contrato contrato, double sueldo,
                     Especialidad especialidad, Departamento departamento, NivelDoctor nivelDoctor) {
        super(nombre, apellido, edad, genero, contrato, sueldo);
        this.especialidad = especialidad;
        this.departamento = departamento;
        this.nivelDoctor = nivelDoctor;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(Especialidad especialidad) {
        this.especialidad = especialidad;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public NivelDoctor getNivelDoctor() {
        return nivelDoctor;
    }

    public void setNivelDoctor(NivelDoctor nivelDoctor) {
        this.nivelDoctor = nivelDoctor;
    }

    public ArrayList<Patient> getListaPacientes() {
        return listaPacientes;
    }

    public void setListaPacientes(ArrayList<Patient> listaPacientes) {
        this.listaPacientes = listaPacientes;
    }

    public ArrayList<LocalTime> getListaGuardias() {
        return listaGuardias;
    }

    public void setListaGuardias(ArrayList<LocalTime> listaGuardias) {
        this.listaGuardias = listaGuardias;
    }

    public ArrayList<LocalTime> getListaPeonadas() {
        return listaPeonadas;
    }

    public void setListaPeonadas(ArrayList<LocalTime> listaPeonadas) {
        this.listaPeonadas = listaPeonadas;
    }

    public ArrayList<LocalTime> getListaConsulta() {
        return listaConsulta;
    }

    public void setListaConsulta(ArrayList<LocalTime> listaConsulta) {
        this.listaConsulta = listaConsulta;
    }
}
