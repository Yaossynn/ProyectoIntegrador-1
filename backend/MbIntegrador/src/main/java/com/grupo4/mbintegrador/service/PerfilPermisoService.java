package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.PerfilPermisoDAO;
import com.grupo4.mbintegrador.model.PerfilPermiso;
import java.util.List;

public class PerfilPermisoService {
    private final PerfilPermisoDAO perfilPermisoDAO;

    public PerfilPermisoService(PerfilPermisoDAO perfilPermisoDAO) {
        this.perfilPermisoDAO = perfilPermisoDAO;
    }

    public PerfilPermiso obtenerPerfilPermisoPorId(int id) {
        return perfilPermisoDAO.findById(id);
    }

    public List<PerfilPermiso> obtenerTodosLosPermisos() {
        return perfilPermisoDAO.findAll();
    }

    public void registrarPerfilPermiso(PerfilPermiso perfilPermiso) {
        perfilPermisoDAO.save(perfilPermiso);
    }

    public void actualizarPerfilPermiso(PerfilPermiso perfilPermiso) {
        perfilPermisoDAO.update(perfilPermiso);
    }

    public void eliminarPerfilPermiso(int id) {
        perfilPermisoDAO.delete(id);
    }
}
