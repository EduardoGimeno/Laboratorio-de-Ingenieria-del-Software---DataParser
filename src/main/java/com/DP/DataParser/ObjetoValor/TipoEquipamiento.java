package com.DP.DataParser.ObjetoValor;

public enum TipoEquipamiento {
    
    CANON("cañon"),
    PANTALLA("pantalla"),
    TV("tv"),
    VIDEO("video"),
    DVD("dvd"),
    PIZARRA("pizarra"),
    ORDENADOR("ordenador");

    private String nombre;
 
    TipoEquipamiento(String nombre) {
        this.nombre = nombre;
    }

    TipoEquipamiento() {}
 
    public String getNombre() {
        return this.nombre;
    }
}