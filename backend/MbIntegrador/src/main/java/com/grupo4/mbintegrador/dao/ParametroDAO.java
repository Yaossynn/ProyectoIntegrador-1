package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Parametro;
import java.util.List;

public interface ParametroDAO {
    Parametro findById(int id);
    List<Parametro> findAll();
    void save(Parametro parametro);
    void update(Parametro parametro);
    void delete(int id);
}
