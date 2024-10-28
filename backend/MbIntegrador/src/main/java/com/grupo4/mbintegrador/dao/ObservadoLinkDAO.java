package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.ObservadoLink;
import java.util.List;

public interface ObservadoLinkDAO {
    ObservadoLink findById(int id);
    List<ObservadoLink> findAll();
    void save(ObservadoLink observadoLink);
    void update(ObservadoLink observadoLink);
    void delete(int id);
}
