package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.CiudadDAO;
import com.grupo4.mbintegrador.model.Ciudad;
import java.util.List;

public class CiudadService {
    private final CiudadDAO ciudadDAO;

    public CiudadService(CiudadDAO ciudadDAO) {
        this.ciudadDAO = ciudadDAO;
    }

    public Ciudad obtenerCiudadPorId(int id) {
        return ciudadDAO.findById(id);
    }

    public List<Ciudad> obtenerTodasLasCiudades() {
        return ciudadDAO.findAll();
    }

    public void registrarCiudad(Ciudad ciudad) {
        ciudadDAO.save(ciudad);
    }

    public void actualizarCiudad(Ciudad ciudad) {
        ciudadDAO.update(ciudad);
    }

    public void eliminarCiudad(int id) {
        ciudadDAO.delete(id);
    }
}
