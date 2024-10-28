package com.grupo4.mbintegrador.dao;

import com.grupo4.mbintegrador.model.Observado;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ObservadoDAOImpl implements ObservadoDAO {

    private final JdbcTemplate jdbcTemplate;

    public ObservadoDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private RowMapper<Observado> observadoRowMapper = new RowMapper<Observado>() {
        @Override
        public Observado mapRow(ResultSet rs, int rowNum) throws SQLException {
            Observado observado = new Observado();
            observado.setIobsId(rs.getInt("iobs_id"));
            observado.setVobsNomb(rs.getString("vobs_nomb"));
            observado.setVobsNomc(rs.getString("vobs_nomc"));
            observado.setIobsEsta(rs.getInt("iobs_esta"));
            observado.setVobsUsuc(rs.getString("vobs_usuc"));
            observado.setVobsUsum(rs.getString("vobs_usum"));
            observado.setDobsFecc(rs.getTimestamp("dobs_fecc"));
            observado.setDobsFecm(rs.getTimestamp("dobs_fecm"));
            return observado;
        }
    };

    @Override
    public Observado findById(int id) {
        String sql = "SELECT * FROM observado WHERE iobs_id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, observadoRowMapper);
    }

    @Override
    public List<Observado> findAll() {
        String sql = "SELECT * FROM observado";
        return jdbcTemplate.query(sql, observadoRowMapper);
    }

    @Override
    public void save(Observado observado) {
        String sql = "INSERT INTO observado (vobs_nomb, vobs_nomc, iobs_esta, vobs_usuc, vobs_usum, dobs_fecc, dobs_fecm) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?)";
        jdbcTemplate.update(sql, observado.getVobsNomb(), observado.getVobsNomc(), observado.getIobsEsta(),
                            observado.getVobsUsuc(), observado.getVobsUsum(), observado.getDobsFecc(), observado.getDobsFecm());
    }

    @Override
    public void update(Observado observado) {
        String sql = "UPDATE observado SET vobs_nomb = ?, vobs_nomc = ?, iobs_esta = ?, vobs_usum = ?, dobs_fecm = ? WHERE iobs_id = ?";
        jdbcTemplate.update(sql, observado.getVobsNomb(), observado.getVobsNomc(), observado.getIobsEsta(),
                            observado.getVobsUsum(), observado.getDobsFecm(), observado.getIobsId());
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM observado WHERE iobs_id = ?";
        jdbcTemplate.update(sql, id);
    }
}
