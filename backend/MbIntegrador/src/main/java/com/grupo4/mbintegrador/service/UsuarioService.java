package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.UsuarioDAO;
import com.grupo4.mbintegrador.model.Usuario;
import java.util.List;

public class UsuarioService {
    private final UsuarioDAO usuarioDAO;

    public UsuarioService(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.findById(id);
    }

    public List<Usuario> obtenerTodosLosUsuarios() {
        return usuarioDAO.findAll();
    }

    public void registrarUsuario(Usuario usuario) {
        usuarioDAO.save(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.update(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioDAO.delete(id);
    }
    
    public Usuario validarCredenciales(String email, String password) {
        List<Usuario> usuarios = usuarioDAO.findAll(); // Deberías filtrar los usuarios por email y clave en una consulta SQL optimizada
        for (Usuario usuario : usuarios) {
            if (usuario.getVusuCorr().equals(email) && usuario.getVusuClav().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}
