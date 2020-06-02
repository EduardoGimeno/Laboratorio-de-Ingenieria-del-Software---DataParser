package com.DP.DataParser.ObjetoValor;

import javax.persistence.Embeddable;

@Embeddable
public class Equipamiento {
    
    private TipoEquipamiento tipo;

    private int cantidad;

    private int maxCantidad;

    public Equipamiento() {
    }

    public Equipamiento(TipoEquipamiento tipo, int cantidad, int maxCantidad) {
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.maxCantidad = maxCantidad;
    }

    public TipoEquipamiento getTipo() { return tipo; }

    public String returnTipoString() {
        return tipo.getNombre();
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getMaxCantidad() {
        return maxCantidad;
    }

    public boolean anadir(int cantidad) {
        if (cantidad + this.cantidad <= this.maxCantidad) {
            this.cantidad += cantidad;
            return true;
        } else {
            return false;
        }
    }

    public boolean quitar(int cantidad) {
        if (this.cantidad - cantidad >= 0) {
            this.cantidad -= cantidad;
            return true;
        } else {
            return false;
        }
    }
}