package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Ciudad;
import java.util.List;
import javax.sql.DataSource;

public class CiudadDAOImpl implements CiudadDAO {
    private final DataSource dataSource;

    public CiudadDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Ciudad findById(int id) {
        // Implementación de la búsqueda por ID
        return null;
    }

    @Override
    public List<Ciudad> findAll() {
        // Implementación de la búsqueda de todos los registros
        return null;
    }

    @Override
    public void save(Ciudad ciudad) {
        // Implementación del guardado de una nueva ciudad
    }

    @Override
    public void update(Ciudad ciudad) {
        // Implementación de la actualización de una ciudad existente
    }

    @Override
    public void delete(int id) {
        // Implementación de la eliminación por ID
    }
}
