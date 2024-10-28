package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Ciudad;
import com.grupo4.mbintegrador.model.TarifaMovil;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class TarifaMovilDAOImpl implements TarifaMovilDAO {

    private final JdbcTemplate jdbcTemplate;

    public TarifaMovilDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<TarifaMovil> tarifaMovilRowMapper = new RowMapper<TarifaMovil>() {
        @Override
        public TarifaMovil mapRow(ResultSet rs, int rowNum) throws SQLException {
            TarifaMovil tarifaMovil = new TarifaMovil();
            tarifaMovil.setItarId(rs.getInt("itar_id"));
            tarifaMovil.setDtarFecc(rs.getTimestamp("dtar_fecc"));
            tarifaMovil.setNtarTarif(rs.getDouble("ntar_tarif"));
            tarifaMovil.setNtarProm(rs.getDouble("ntar_prom"));
            tarifaMovil.setTtarHsal(rs.getString("ttar_hsal"));
            tarifaMovil.setVtarCate(rs.getString("vtar_cate"));
        
            Ciudad ciudadOrigen = new Ciudad();
            ciudadOrigen.setIciuId(rs.getInt("iciu_idor"));
            tarifaMovil.setCiudadOrigen(ciudadOrigen);

            Ciudad ciudadDestino = new Ciudad();
            ciudadDestino.setIciuId(rs.getInt("iciu_idde"));
            tarifaMovil.setCiudadDestino(ciudadDestino);
            
            return tarifaMovil;
        }
    };

    @Override
    public TarifaMovil findById(int id) {
        String sql = "SELECT * FROM tarifa_movil WHERE itar_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, tarifaMovilRowMapper);
    }

    @Override
    public List<TarifaMovil> findAll() {
        String sql = "SELECT * FROM tarifa_movil";
        return jdbcTemplate.query(sql, tarifaMovilRowMapper);
    }

    @Override
    public void save(TarifaMovil tarifaMovil) {
        String sql = "INSERT INTO tarifa_movil (dtar_fecc, ntar_tarif, ntar_prom, ttar_hsal, vtar_cate, iciu_idor, iciu_idde) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql,
                tarifaMovil.getDtarFecc(), 
                tarifaMovil.getNtarTarif(), 
                tarifaMovil.getNtarProm(),
                tarifaMovil.getTtarHsal(), 
                tarifaMovil.getVtarCate(),
                tarifaMovil.getCiudadOrigen().getIciuId(),  // Obtenemos el id de la ciudad de origen
                tarifaMovil.getCiudadDestino().getIciuId());  // Obtenemos el id de la ciudad de destino
    }

    @Override
    public void update(TarifaMovil tarifaMovil) {
        String sql = "UPDATE tarifa_movil SET dtar_fecc = ?, ntar_tarif = ?, ntar_prom = ?, ttar_hsal = ?, vtar_cate = ?, iciu_idor = ?, iciu_idde = ? WHERE itar_id = ?";
        jdbcTemplate.update(sql,
                tarifaMovil.getDtarFecc(), 
                tarifaMovil.getNtarTarif(), 
                tarifaMovil.getNtarProm(),
                tarifaMovil.getTtarHsal(), 
                tarifaMovil.getVtarCate(),
                tarifaMovil.getCiudadOrigen().getIciuId(),  // Obtenemos el id de la ciudad de origen
                tarifaMovil.getCiudadDestino().getIciuId(),  // Obtenemos el id de la ciudad de destino
                tarifaMovil.getItarId());
    }


    @Override
    public void delete(int id) {
        String sql = "DELETE FROM tarifa_movil WHERE itar_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
