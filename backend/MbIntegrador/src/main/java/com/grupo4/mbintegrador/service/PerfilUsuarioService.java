package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.PerfilUsuarioDAO;
import com.grupo4.mbintegrador.model.PerfilUsuario;
import java.util.List;

public class PerfilUsuarioService {
    private final PerfilUsuarioDAO perfilUsuarioDAO;

    public PerfilUsuarioService(PerfilUsuarioDAO perfilUsuarioDAO) {
        this.perfilUsuarioDAO = perfilUsuarioDAO;
    }

    public PerfilUsuario obtenerPerfilUsuarioPorId(int id) {
        return perfilUsuarioDAO.findById(id);
    }

    public List<PerfilUsuario> obtenerTodosLosPerfiles() {
        return perfilUsuarioDAO.findAll();
    }

    public void registrarPerfilUsuario(PerfilUsuario perfilUsuario) {
        perfilUsuarioDAO.save(perfilUsuario);
    }

    public void actualizarPerfilUsuario(PerfilUsuario perfilUsuario) {
        perfilUsuarioDAO.update(perfilUsuario);
    }

    public void eliminarPerfilUsuario(int id) {
        perfilUsuarioDAO.delete(id);
    }
}