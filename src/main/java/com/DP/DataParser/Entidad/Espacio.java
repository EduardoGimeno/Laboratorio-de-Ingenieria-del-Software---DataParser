package com.DP.DataParser.Entidad;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import com.DP.DataParser.ObjetoValor.Equipamiento;
import com.DP.DataParser.ObjetoValor.Ubicacion;
import java.util.ArrayList;
import java.util.List;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

@Entity
public class Espacio {
    @Id
    private String id;

    @NotNull
    private String nombre;

    @NotNull
    private String tipo;

    @NotNull
    @Min(0)
    private int capacidad;

    @NotNull
    @Embedded
    @ElementCollection(targetClass= Equipamiento.class, fetch=FetchType.EAGER)
    private List<Equipamiento> equipamiento = new ArrayList<>();

    @NotNull
    @Embedded
    private Ubicacion ubicacion;

    private String notas;

    @NotNull
    private Boolean reservable;

    @NotNull
    @JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "geom", columnDefinition = "GEOMETRY")
    private Geometry geom;

    public Espacio(String id, String nombre, String tipo, int capacidad, List<Equipamiento> equipamiento,
                   Ubicacion ubicacion, Geometry geom) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.equipamiento = equipamiento;
        this.ubicacion = ubicacion;
        this.geom = geom;
        this.id = id;
    }

    public Espacio() {}

    public String getId() {
        return this.id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getTipo() {
        return this.tipo;
    }

    public int getCapacidad() {
        return this.capacidad;
    }

    public List<Equipamiento> getEquipamiento() {
        return this.equipamiento;
    }

    public Ubicacion getUbicacion() {
        return this.ubicacion;
    }

    public Geometry getGeom() {
        return this.geom;
    }

    public String getNotas() {
        return this.notas;
    }

    public Boolean getReservable() { return this.reservable; }

    public void modificar (List<Equipamiento> equipamiento, int capacidad, Boolean reservable, String notas) {
        this.equipamiento = equipamiento;
        this.capacidad = capacidad;
        this.reservable = reservable;
        this.notas = notas;
    } 
}