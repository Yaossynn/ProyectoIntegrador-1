package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.ObservadoLink;
import java.util.List;
import javax.sql.DataSource;

public class ObservadoLinkDAOImpl implements ObservadoLinkDAO {
    private final DataSource dataSource;

    public ObservadoLinkDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public ObservadoLink findById(int id) {
        // Implementación de la búsqueda por ID
        return null;
    }

    @Override
    public List<ObservadoLink> findAll() {
        // Implementación de la búsqueda de todos los registros
        return null;
    }

    @Override
    public void save(ObservadoLink observadoLink) {
        // Implementación del guardado de un nuevo enlace observado
    }

    @Override
    public void update(ObservadoLink observadoLink) {
        // Implementación de la actualización de un enlace observado existente
    }

    @Override
    public void delete(int id) {
        // Implementación de la eliminación por ID
    }
}
