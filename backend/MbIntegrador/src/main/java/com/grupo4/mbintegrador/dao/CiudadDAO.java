package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Ciudad;
import java.util.List;

public interface CiudadDAO {
    Ciudad findById(int id);
    List<Ciudad> findAll();
    void save(Ciudad ciudad);
    void update(Ciudad ciudad);
    void delete(int id);
}
