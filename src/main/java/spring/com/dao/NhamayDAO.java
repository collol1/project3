package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.Nhamay;

public class NhamayDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Nhamay n) {
        String sql = "INSERT INTO nhamay (nhamay_id, ten_nha_may, dia_chi, so_dien_thoai) VALUES (?, ?, ?, ?)";
        return template.update(sql, n.getNhamayId(), n.getTenNhaMay(), n.getDiaChi(), n.getSoDienThoai());
    }

    public int update(Nhamay n) {
        String sql = "UPDATE nhamay SET ten_nha_may=?, dia_chi=?, so_dien_thoai=? WHERE nhamay_id=?";
        return template.update(sql, n.getTenNhaMay(), n.getDiaChi(), n.getSoDienThoai(), n.getNhamayId());
    }

    public int delete(String id) {
        String sql = "DELETE FROM nhamay WHERE nhamay_id=?";
        return template.update(sql, id);
    }

    public Nhamay getById(String id) {
        String sql = "SELECT * FROM nhamay WHERE nhamay_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Nhamay.class));
    }

    public List<Nhamay> getAll() {
        return template.query("SELECT * FROM nhamay", new RowMapper<Nhamay>() {
            @Override
			public Nhamay mapRow(ResultSet rs, int row) throws SQLException {
                Nhamay n = new Nhamay();
                n.setNhamayId(rs.getString("nhamay_id"));
                n.setTenNhaMay(rs.getString("ten_nha_may"));
                n.setDiaChi(rs.getString("dia_chi"));
                n.setSoDienThoai(rs.getString("so_dien_thoai"));
                return n;
            }
        });
    }
}
