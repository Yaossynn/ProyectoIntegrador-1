package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.TarifaMovil;
import java.util.List;

public interface TarifaMovilDAO {
    TarifaMovil findById(int id);
    List<TarifaMovil> findAll();
    void save(TarifaMovil tarifaMovil);
    void update(TarifaMovil tarifaMovil);
    void delete(int id);
}
