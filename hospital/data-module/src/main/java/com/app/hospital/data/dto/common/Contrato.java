package com.app.hospital.data.dto.common;

import java.time.LocalTime;

public class Contrato {

    private TIPO_CONTRATO   contrato;

    private LocalTime       inicio;

    private LocalTime       fin;

    public Contrato(TIPO_CONTRATO contrato, LocalTime inicio, LocalTime fin) {
        this.contrato = contrato;
        this.inicio = inicio;
        this.fin = fin;
    }

    public TIPO_CONTRATO getContrato() {
        return contrato;
    }

    public void setContrato(TIPO_CONTRATO contrato) {
        this.contrato = contrato;
    }

    public LocalTime getInicio() {
        return inicio;
    }

    public void setInicio(LocalTime inicio) {
        this.inicio = inicio;
    }

    public LocalTime getFin() {
        return fin;
    }

    public void setFin(LocalTime fin) {
        this.fin = fin;
    }

    public enum TIPO_CONTRATO {
        TEMPORAL("temporal"),
        INDEFINIDO("indefinido"),
        SUPLENTE("suplente");

        private String tipoContrato;

        private TIPO_CONTRATO(String tipoContrato) {
            this.tipoContrato = tipoContrato;
        }

        public String getTipoContrato() { return tipoContrato; }
    }
}
