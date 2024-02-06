package com.app.hospital.data.dto.common;

public enum Genero {
    HOMBRE("hombre"),
    MUJER("mujer"),
    SUCEDANEO("otro");

    private String genero;

    private Genero(String genero) {
        this.genero = genero;
    }

    public String getGenero() { return genero; }
}
