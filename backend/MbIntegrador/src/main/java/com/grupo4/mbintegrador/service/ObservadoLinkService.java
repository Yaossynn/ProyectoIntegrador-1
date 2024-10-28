package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.ObservadoLinkDAO;
import com.grupo4.mbintegrador.model.ObservadoLink;
import java.util.List;

public class ObservadoLinkService {
    private final ObservadoLinkDAO observadoLinkDAO;

    public ObservadoLinkService(ObservadoLinkDAO observadoLinkDAO) {
        this.observadoLinkDAO = observadoLinkDAO;
    }

    public ObservadoLink obtenerObservadoLinkPorId(int id) {
        return observadoLinkDAO.findById(id);
    }

    public List<ObservadoLink> obtenerTodosLosObservadoLinks() {
        return observadoLinkDAO.findAll();
    }

    public void registrarObservadoLink(ObservadoLink observadoLink) {
        observadoLinkDAO.save(observadoLink);
    }

    public void actualizarObservadoLink(ObservadoLink observadoLink) {
        observadoLinkDAO.update(observadoLink);
    }

    public void eliminarObservadoLink(int id) {
        observadoLinkDAO.delete(id);
    }
}
