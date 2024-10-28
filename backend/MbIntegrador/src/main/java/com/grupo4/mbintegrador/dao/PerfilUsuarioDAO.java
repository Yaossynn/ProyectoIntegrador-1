package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.PerfilUsuario;
import java.util.List;

public interface PerfilUsuarioDAO {
    PerfilUsuario findById(int id);
    List<PerfilUsuario> findAll();
    void save(PerfilUsuario perfilUsuario);
    void update(PerfilUsuario perfilUsuario);
    void delete(int id);
}