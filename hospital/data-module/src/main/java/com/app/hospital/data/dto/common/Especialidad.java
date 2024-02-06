package com.app.hospital.data.dto.common;

public enum Especialidad {

    CIRUJANO("cirujano"),
    TRAUMATOLOGO("traumatólogo"),
    ANESTESISTA("anestesista"),

    GENERAL("médico general"),
    GERIATRA("geriatra");

    private String especialidad;

    private Especialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getEspecialidad() { return especialidad; }

}
