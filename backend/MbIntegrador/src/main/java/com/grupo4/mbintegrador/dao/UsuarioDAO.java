package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Usuario;
import java.util.List;

public interface UsuarioDAO {
    Usuario findById(int id);
    List<Usuario> findAll();
    void save(Usuario usuario);
    void update(Usuario usuario);
    void delete(int id);
    Usuario findByEmail(String email); // Para login
}
