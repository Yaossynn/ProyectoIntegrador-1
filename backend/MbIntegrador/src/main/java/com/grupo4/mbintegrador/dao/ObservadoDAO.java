package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Observado;
import java.util.List;

public interface ObservadoDAO {
    Observado findById(int id);
    List<Observado> findAll();
    void save(Observado observado);
    void update(Observado observado);
    void delete(int id);
}
