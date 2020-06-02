package com.DP.DataParser.Repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.DP.DataParser.Entidad.EspaciosSinFiltrar;
import java.util.List;

@Repository
public interface EspacioSinFiltrarRepository extends CrudRepository<EspaciosSinFiltrar, Integer> {

    List<EspaciosSinFiltrar> findAll();
    
}