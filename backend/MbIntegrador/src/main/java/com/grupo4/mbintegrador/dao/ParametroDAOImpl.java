package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Parametro;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ParametroDAOImpl implements ParametroDAO {

    private final JdbcTemplate jdbcTemplate;

    public ParametroDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Parametro> parametroRowMapper = new RowMapper<Parametro>() {
        @Override
        public Parametro mapRow(ResultSet rs, int rowNum) throws SQLException {
            Parametro parametro = new Parametro();
            parametro.setIparamId(rs.getInt("iparam_id"));
            parametro.setVariable(rs.getString("variable"));
            parametro.setValor(rs.getString("valor"));
            return parametro;
        }
    };

    @Override
    public Parametro findById(int id) {
        String sql = "SELECT * FROM parametro WHERE iparam_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, parametroRowMapper);
    }

    @Override
    public List<Parametro> findAll() {
        String sql = "SELECT * FROM parametro";
        return jdbcTemplate.query(sql, parametroRowMapper);
    }

    @Override
    public void save(Parametro parametro) {
        String sql = "INSERT INTO parametro (variable, valor) VALUES (?, ?)";
        jdbcTemplate.update(sql, parametro.getVariable(), parametro.getValor());
    }

    @Override
    public void update(Parametro parametro) {
        String sql = "UPDATE parametro SET variable = ?, valor = ? WHERE iparam_id = ?";
        jdbcTemplate.update(sql, parametro.getVariable(), parametro.getValor(), parametro.getIparamId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM parametro WHERE iparam_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
