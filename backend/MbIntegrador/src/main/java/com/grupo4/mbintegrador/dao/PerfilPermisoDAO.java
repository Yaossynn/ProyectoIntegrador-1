package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.PerfilPermiso;
import java.util.List;

public interface PerfilPermisoDAO {
    PerfilPermiso findById(int id);
    List<PerfilPermiso> findAll();
    void save(PerfilPermiso perfilPermiso);
    void update(PerfilPermiso perfilPermiso);
    void delete(int id);
}
