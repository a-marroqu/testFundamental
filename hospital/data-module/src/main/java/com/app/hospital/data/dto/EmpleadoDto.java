package com.app.hospital.data.dto;

import com.app.hospital.data.dto.common.Contrato;
import com.app.hospital.data.dto.common.Genero;
import com.app.hospital.data.dto.common.Turno;

public abstract class EmpleadoDto {

    private int         idEmpleado;

    private String      nombre;

    private String      apellido;

    private int         edad;

    private Genero      genero;

    private Contrato    contrato;

    private double      sueldo;

    private Turno       turno;

    private int         diasVacaciones;

    private int         diasAsuntosPropios;

    public EmpleadoDto(String nombre, String apellido, int edad, Genero genero, Contrato contrato,
                       double sueldo) {
        //this.idEmpleado = generarIdEmpleado();
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.genero = genero;
        this.contrato = contrato;
        this.sueldo = sueldo;
        this.diasVacaciones = 24;
        this.diasAsuntosPropios = 2;
    }

//    private int generarIdEmpleado() {
//        return 0;
//    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

//    public void setIdEmpleado(int idEmpleado) {
//        this.idEmpleado = idEmpleado;
//    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Contrato getContrato() {
        return contrato;
    }

    public void setContrato(Contrato contrato) {
        this.contrato = contrato;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Turno getTurno() {
        return turno;
    }

    public void setTurno(Turno turno) {
        this.turno = turno;
    }

    public int getDiasVacaciones() {
        return diasVacaciones;
    }

    public void setDiasVacaciones(int diasVacaciones) {
        this.diasVacaciones = diasVacaciones;
    }

    public int getDiasAsuntosPropios() {
        return diasAsuntosPropios;
    }

    public void setDiasAsuntosPropios(int diasAsuntosPropios) {
        this.diasAsuntosPropios = diasAsuntosPropios;
    }
}
