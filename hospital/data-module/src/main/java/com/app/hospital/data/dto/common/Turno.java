package com.app.hospital.data.dto.common;

import java.time.LocalTime;

public enum Turno {

    DIURNO("diurno", LocalTime.of(8,0), LocalTime.of(15, 0)),
    VESPERTINO("vespertino", LocalTime.of(15,0), LocalTime.of(22, 0)),
    NOCTURNO("nocturno", LocalTime.of(0,0), LocalTime.of(7, 0));

    private String      turno;

    private LocalTime   inicioTurno;

    private LocalTime   finTurno;

    private Turno(String turno, LocalTime inicioTurno, LocalTime finTurno) {
        this.turno = turno;
        this.inicioTurno = inicioTurno;
        this.finTurno = finTurno;
    }

    public String getTurno() { return turno; }

    public LocalTime getInicioTurno() { return inicioTurno; }

    public LocalTime getFinTurno() { return finTurno; }
}
