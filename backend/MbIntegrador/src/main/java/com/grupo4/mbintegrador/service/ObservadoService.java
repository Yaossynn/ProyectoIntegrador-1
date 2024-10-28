package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.ObservadoDAO;
import com.grupo4.mbintegrador.model.Observado;
import java.util.List;

public class ObservadoService {
    private final ObservadoDAO observadoDAO;

    public ObservadoService(ObservadoDAO observadoDAO) {
        this.observadoDAO = observadoDAO;
    }

    public Observado obtenerObservadoPorId(int id) {
        return observadoDAO.findById(id);
    }

    public List<Observado> obtenerTodosLosObservados() {
        return observadoDAO.findAll();
    }

    public void registrarObservado(Observado observado) {
        observadoDAO.save(observado);
    }

    public void actualizarObservado(Observado observado) {
        observadoDAO.update(observado);
    }

    public void eliminarObservado(int id) {
        observadoDAO.delete(id);
    }
}
