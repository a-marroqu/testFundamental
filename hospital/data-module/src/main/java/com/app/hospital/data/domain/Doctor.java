package com.app.hospital.data.domain;

import com.app.hospital.data.dto.common.Departamento;
import com.app.hospital.data.dto.common.Especialidad;
import com.app.hospital.data.dto.common.Genero;
import com.app.hospital.data.dto.common.NivelDoctor;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "doctors")
@NoArgsConstructor
@AllArgsConstructor
public class Doctor extends Empleado {

    @Enumerated
    @Column(name = "doctor_especialidad")
    @JsonProperty(required = true)
    private Especialidad especialidad;

    @Enumerated
    @Column(name = "doctor_departamento")
    @JsonProperty(required = true)
    private Departamento departamento;

    @Enumerated
    @Column(name = "doctor_nivel")
    @JsonProperty(required = true)
    private NivelDoctor nivelDoctor;

    @OneToMany
    private List<Patient> listaPacientes;

//    @ElementCollection
//    @CollectionTable(name = "doctor_guardias")
//    @JsonProperty(required = true)
//    private ArrayList<LocalTime> listaGuardias = new ArrayList<>();
//
//    @ElementCollection
//    @CollectionTable(name = "doctor_peonadas")
//    @JsonProperty(required = true)
//    private ArrayList<LocalTime> listaPeonadas = new ArrayList<>();
//
//    @ElementCollection
//    @CollectionTable(name = "doctor_consultas")
//    @JsonProperty(required = true)
//    private ArrayList<LocalTime> listaConsultas = new ArrayList<>();
}
