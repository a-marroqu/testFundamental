package com.app.hospital.data.dto.common;

public enum NivelDoctor {

    RESIDENTE("residente"),
    ADJUNTO("adjunto"),
    MEDICO("médico"),
    ESPECIALISTA("especialista");

    private String nivel;

    private NivelDoctor(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel() { return nivel; }
}
