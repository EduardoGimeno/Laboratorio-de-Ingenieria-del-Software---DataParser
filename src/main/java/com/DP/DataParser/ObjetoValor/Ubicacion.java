package com.DP.DataParser.ObjetoValor;

import javax.persistence.Embeddable;

@Embeddable
public class Ubicacion {
    private String edificio;

    private int planta;

    public Ubicacion() { }

    public Ubicacion(String edificio, int planta) {
        this.edificio = edificio;
        this.planta = planta;
    }

    public String getEdificio() {
        return this.edificio;
    }

    public int getPlanta() {
        return this.planta;
    }
}