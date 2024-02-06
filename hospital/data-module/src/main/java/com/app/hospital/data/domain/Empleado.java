package com.app.hospital.data.domain;

import com.app.hospital.data.dto.common.Contrato;
import com.app.hospital.data.dto.common.Genero;
import com.app.hospital.data.dto.common.Turno;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalTime;

@MappedSuperclass
public abstract class Empleado implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empleado_id")
    private Long id;

    @Column(name = "empleado_name")
    @JsonProperty(required = true)
    private String nombre;

    @Column(name = "empleado_apellido")
    @JsonProperty(required = true)
    private String apellido;

    @Column(name = "empleado_edad")
    @JsonProperty(required = true)
    private int edad;

    @Enumerated
    @Column(name = "empleado_genero")
    @JsonProperty(required = true)
    private Genero genero;

    @Column(name = "empleado_contrato")
    @JsonProperty(required = true)
    private Contrato.TIPO_CONTRATO tipo_contrato;

    @Column(name = "empleado_inicioContrato")
    @JsonProperty(required = true)
    private LocalTime inicioContrato;

    @Column(name = "empleado_finContrato")
    @JsonProperty(required = true)
    private LocalTime finContrato;

    @Column(name = "empleado_sueldo")
    @JsonProperty(required = true)
    private double sueldo;

//    @Enumerated
//    @Column(name = "empleado_turno")
//    @JsonProperty(required = true)
//    private Turno turno;

    @Column(name = "empleado_vacaciones")
    @JsonProperty(required = true)
    private int diasVacaciones;

    @Column(name = "empleado_diasAsuntosPropios")
    @JsonProperty(required = true)
    private int diasAsuntosPropios;
}
