package com.app.hospital.data.dto.common;

public enum Departamento {

    MEDICINA("medicina"),
    CIRUGIA("cirugía");

    private String departamento;

    private Departamento(String departamento) {
        this.departamento = departamento;
    }

    public String getDepartamento() { return departamento; }

}
