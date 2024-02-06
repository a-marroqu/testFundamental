package com.app.hospital.data.dto.common;

public enum Baja {

    NACIMIENTO_BEBE("nacimiento hijo", false),
    ENFERMEDAD("enfermedad", false),
    MUERTE_FAMILIAR("muerte familiar", false),
    CUIDAR_FAMILIAR("cuidar familiar", false),
    DEPRESION("depresion", false),
    DEBER_PATRIO("deber patrio", false);

    private String  baja;

    private boolean activa;

    private Baja(String tipoBaja, boolean activa) {
        this.baja = tipoBaja;
        this.activa = activa;
    }

    public String getBaja() { return baja; }

    public boolean getActiva() { return activa; }
}
