package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.TarifaMovilDAO;
import com.grupo4.mbintegrador.model.TarifaMovil;
import java.util.List;

public class TarifaMovilService {
    private final TarifaMovilDAO tarifaMovilDAO;

    public TarifaMovilService(TarifaMovilDAO tarifaMovilDAO) {
        this.tarifaMovilDAO = tarifaMovilDAO;
    }

    public TarifaMovil obtenerTarifaMovilPorId(int id) {
        return tarifaMovilDAO.findById(id);
    }

    public List<TarifaMovil> obtenerTodasLasTarifas() {
        return tarifaMovilDAO.findAll();
    }

    public void registrarTarifaMovil(TarifaMovil tarifaMovil) {
        tarifaMovilDAO.save(tarifaMovil);
    }

    public void actualizarTarifaMovil(TarifaMovil tarifaMovil) {
        tarifaMovilDAO.update(tarifaMovil);
    }

    public void eliminarTarifaMovil(int id) {
        tarifaMovilDAO.delete(id);
    }
}
