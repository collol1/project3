package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.VitriNhanvien;

public class VitriNhanvienDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(VitriNhanvien v) {
        String sql = "INSERT INTO vitrinhanvien (vitri_id, ten_vi_tri, luong_co_ban) VALUES (?, ?, ?)";
        return template.update(sql, v.getVitriId(), v.getTenViTri(), v.getLuongCoBan());
    }

    public int update(VitriNhanvien v) {
        String sql = "UPDATE vitrinhanvien SET ten_vi_tri=?, luong_co_ban=? WHERE vitri_id=?";
        return template.update(sql, v.getTenViTri(), v.getLuongCoBan(), v.getVitriId());
    }

    public int delete(String id) {
        String sql = "DELETE FROM vitrinhanvien WHERE vitri_id=?";
        return template.update(sql, id);
    }

    public VitriNhanvien getById(String id) {
        String sql = "SELECT * FROM vitrinhanvien WHERE vitri_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(VitriNhanvien.class));
    }

    public List<VitriNhanvien> getAll() {
        return template.query("SELECT * FROM vitrinhanvien", new RowMapper<VitriNhanvien>() {
            @Override
			public VitriNhanvien mapRow(ResultSet rs, int row) throws SQLException {
                VitriNhanvien v = new VitriNhanvien();
                v.setVitriId(rs.getString("vitri_id"));
                v.setTenViTri(rs.getString("ten_vi_tri"));
                v.setLuongCoBan(rs.getDouble("luong_co_ban"));
                return v;
            }
        });
    }
}
