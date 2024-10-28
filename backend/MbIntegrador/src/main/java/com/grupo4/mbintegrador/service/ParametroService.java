 package com.grupo4.mbintegrador.service;

import com.grupo4.mbintegrador.dao.ParametroDAO;
import com.grupo4.mbintegrador.model.Parametro;
import java.util.List;
 
public class ParametroService {
    private final ParametroDAO parametroDAO;

    public ParametroService(ParametroDAO parametroDAO) {
        this.parametroDAO = parametroDAO;
    }

    public Parametro obtenerParametroPorId(int id) {
        return parametroDAO.findById(id);
    }

    public List<Parametro> obtenerTodosLosParametros() {
        return parametroDAO.findAll();
    }

    public void registrarParametro(Parametro parametro) {
        parametroDAO.save(parametro);
    }

    public void actualizarParametro(Parametro parametro) {
        parametroDAO.update(parametro);
    }

    public void eliminarParametro(int id) {
        parametroDAO.delete(id);
    }
}
