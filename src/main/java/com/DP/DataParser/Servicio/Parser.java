package com.DP.DataParser.Servicio;

import com.DP.DataParser.Repositorio.EspacioRepository;
import com.DP.DataParser.Repositorio.EspacioSinFiltrarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.DP.DataParser.Entidad.Espacio;
import com.DP.DataParser.Entidad.EspaciosSinFiltrar;
import com.DP.DataParser.ObjetoValor.Equipamiento;
import com.DP.DataParser.ObjetoValor.TipoEquipamiento;
import com.DP.DataParser.ObjetoValor.Ubicacion;
import com.vividsolutions.jts.geom.Geometry;
import java.util.ArrayList;
import java.util.List;

@Service
public class Parser {
    
    @Autowired
    private EspacioSinFiltrarRepository espacioSinFiltrarRepository;
    @Autowired
    private EspacioRepository espacioRepository;

    public Parser() {}

    public void crearEspacios() {
        List<EspaciosSinFiltrar> ls = espacioSinFiltrarRepository.findAll();

        for (int i=0; i<ls.size(); ++i) {
            EspaciosSinFiltrar esf = ls.get(i);
            String tipo = esf.getIdCentro();
            Boolean valido = false;
            String tipoEspacio = "Error";

            // Obtener el tipo de espacio
            if (tipo.contains("AULA")) {
                valido = true;
                tipoEspacio = "Aula";
            } else if(tipo.contains("LAB")) {
                valido = true;
                tipoEspacio = "Laboratorio";
            } else if(tipo.contains("SEMINARIO")) {
                valido = true;
                tipoEspacio = "Seminario";
            } else if(tipo.contains("SALON DE ACTOS")) {
                valido = true;
                tipoEspacio = "Salon de actos";
            } else if(tipo.contains("SALA")) {
                valido = true;
                tipoEspacio = "Sala";
            }

            // Si es un espacio válido, obtener el resto de campos
            if (valido) {
                // Identificador único del espacio
                String id = esf.getIdEspacio();
                // Nombre del espacio
                String nombre = esf.getIdCentro();
                // Capacidad del espacio
                int capacidad = esf.getNmroPlzas();

                // Equipamientos del espacio
                List<Equipamiento> le = new ArrayList<>();
                if (esf.getCanonFijo() > 0) {
                    Equipamiento canon = new Equipamiento(TipoEquipamiento.CANON,
                                                        esf.getCanonFijo(), esf.getCanonFijo());
                    le.add(canon);
                }
                if (esf.getPantallaProyector() > 0) {
                    Equipamiento pantalla = new Equipamiento(TipoEquipamiento.PANTALLA,
                                                            esf.getPantallaProyector(), esf.getPantallaProyector());
                    le.add(pantalla);
                }
                if (esf.getTv() > 0) {
                    Equipamiento tv = new Equipamiento(TipoEquipamiento.TV,
                                                    esf.getTv(), esf.getTv());
                    le.add(tv);
                }
                if (esf.getDvd() > 0) {
                    Equipamiento dvd = new Equipamiento(TipoEquipamiento.DVD,
                                                        esf.getDvd(), esf.getDvd());
                    le.add(dvd);
                }
                if (esf.getVideo() > 0) {
                    Equipamiento video = new Equipamiento(TipoEquipamiento.VIDEO,
                                                        esf.getVideo(), esf.getVideo());
                    le.add(video);
                }
                if (esf.getPizarra() > 0) {
                    Equipamiento pizarra = new Equipamiento(TipoEquipamiento.PIZARRA,
                                                            esf.getPizarra(), esf.getPizarra());

                    le.add(pizarra);
                }
                if (esf.getOrdenadores() > 0) {
                    Equipamiento ordenadores = new Equipamiento(TipoEquipamiento.ORDENADOR,
                                                            esf.getOrdenadores(), esf.getOrdenadores());

                    le.add(ordenadores);
                }

                // Edificio y planta del espacio
                String edificio = "Error";
                if (esf.getIdEdificio().contains("1200")) {
                    edificio = "Ada Byron";
                } else if (esf.getIdEdificio().contains("1201")) {
                    edificio = "Betancourt";
                } else if (esf.getIdEdificio().contains("1065")) {
                    edificio = "Torres Quevedo";
                }
                int planta = -1;
                if (esf.getIdUtc().contains("00.")) {
                    planta = 0;
                } else if (esf.getIdUtc().contains("01.")) {
                    planta = 1;
                } else if (esf.getIdUtc().contains("02.")) {
                    planta = 2;
                } else if (esf.getIdUtc().contains("03.")) {
                    planta = 3;
                } else if (esf.getIdUtc().contains("04.")) {
                    planta = 4;
                }
                Ubicacion ubicacion = new Ubicacion(edificio, planta);

                // Geometría
                Geometry geom = esf.getGeom();

                Espacio e = new Espacio(id, nombre, tipoEspacio, capacidad, le, ubicacion, geom);

                espacioRepository.save(e);
            } else {
                System.out.println("Espacio no valido");
            }
        }
    }
}