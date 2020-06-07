package com.DP.DataParser.Entidad;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vividsolutions.jts.geom.Geometry;

/*
 * Los nombres de los atributos aparecen cortados porque
 * el nombre de los campos con los que se relacionan
 * en la base de datos han quedado limitados a diez
 * caracteres.
 */
@Entity
@Table(name = "espacios_sin_filtrar")
public class EspaciosSinFiltrar {

    @Id
    private Integer id;

    @NotNull
    @JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(using = GeometryDeserializer.class)
    @Column(name = "geom", columnDefinition = "GEOMETRY")
    private Geometry geom;

    @NotNull
    private String layer;

    @NotNull
    private String id_espacio;

    @NotNull
    private String id_edifici;

    @NotNull
    private String id_utc;

    @NotNull
    private String id_centro;

    @NotNull
    private Integer tipo_de_us;

    @NotNull
    private Integer caon_fijo;

    @NotNull
    private Integer pantalla_p;

    @NotNull
    private Integer tv;

    @NotNull
    private Integer dvd;

    @NotNull
    private Integer video;

    @NotNull
    private Integer ordenadore;

    @NotNull
    private Integer pizarra;

    @NotNull
    private Integer nmro_plaza;

    public EspaciosSinFiltrar(Integer id, Geometry geom, String layer, String id_espacio,
                             String id_edificio, String id_utc, String id_centro,
                             Integer tipo_de_uso, Integer canon_fijo, Integer pantalla_proyector,
                             Integer tv, Integer dvd, Integer video, Integer ordenadores,
                             Integer pizarra, Integer nmro_plazas) {
        this.id = id;
        this.geom = geom;
        this.layer = layer;
        this.id_espacio = id_espacio;
        this.id_edifici = id_edificio;
        this.id_utc = id_utc;
        this.id_centro = id_centro;
        this.tipo_de_us = tipo_de_uso;
        this.caon_fijo = canon_fijo;
        this.pantalla_p = pantalla_proyector;
        this.tv = tv;
        this.dvd = dvd;
        this.video = video;
        this.ordenadore = ordenadores;
        this.pizarra = pizarra;
        this.nmro_plaza = nmro_plazas;
    }

    public EspaciosSinFiltrar() {}

    public Integer getId() {
        return this.id;
    }

    @JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(using = GeometryDeserializer.class)
	@Column(name = "geom", columnDefinition = "GEOMETRY")
    public Geometry getGeom() {
        return this.geom;
    }

    public String getLayer() {
        return this.layer;
    }

    public String getIdEspacio() {
        return this.id_espacio;
    }

    public String getIdEdificio() {
        return this.id_edifici;
    }

    public String getIdUtc() {
        return this.id_utc;
    }

    public String getIdCentro() {
        return this.id_centro;
    }

    public Integer getTipoDeUso() {
        return this.tipo_de_us;
    }

    public Integer getCanonFijo() {
        return this.caon_fijo;
    }

    public Integer getPantallaProyector() {
        return this.pantalla_p;
    }

    public Integer getTv() {
        return this.tv;
    }

    public Integer getDvd() {
        return this.dvd;
    }

    public Integer getVideo() {
        return this.video;
    }

    public Integer getOrdenadores() {
        return this.ordenadore;
    }

    public Integer getPizarra() {
        return this.pizarra;
    }

    public Integer getNmroPlzas() {
        return this.nmro_plaza;
    }
}