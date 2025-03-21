package spring.com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import spring.com.beans.Nhanvien;

public class NhanvienDAO {
    JdbcTemplate template;

    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    public int save(Nhanvien n) {
        String sql = "INSERT INTO nhanvien (nhanvien_id, ho_ten, ngay_sinh, gioi_tinh, dia_chi, so_dien_thoai, vitri_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        return template.update(sql, n.getNhanvienId(), n.getHoTen(), n.getNgaySinh(), n.getGioiTinh(), n.getDiaChi(), n.getSoDienThoai(), n.getVitriId());
    }

    public int update(Nhanvien n) {
        String sql = "UPDATE nhanvien SET ho_ten=?, ngay_sinh=?, gioi_tinh=?, dia_chi=?, so_dien_thoai=?, vitri_id=? WHERE nhanvien_id=?";
        
        System.out.println("DEBUG - SQL Update: " + sql);
        System.out.println("DEBUG - Dữ liệu: " + n);
        
        return template.update(sql, n.getHoTen(), n.getNgaySinh(), n.getGioiTinh(), 
                               n.getDiaChi(), n.getSoDienThoai(), n.getVitriId(), 
                               n.getNhanvienId());
    }



    public int delete(String id) {
        String sql = "DELETE FROM nhanvien WHERE nhanvien_id=?";
        return template.update(sql, id);
    }

    public Nhanvien getById(String id) {
        String sql = "SELECT * FROM nhanvien WHERE nhanvien_id=?";
        return template.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Nhanvien.class));
    }

    public List<Nhanvien> getAll() {
        return template.query("SELECT * FROM nhanvien", new RowMapper<Nhanvien>() {
            @Override
			public Nhanvien mapRow(ResultSet rs, int row) throws SQLException {
                Nhanvien n = new Nhanvien();
                n.setNhanvienId(rs.getString("nhanvien_id"));
                n.setHoTen(rs.getString("ho_ten"));
                n.setNgaySinh(rs.getString("ngay_sinh"));
                n.setGioiTinh(rs.getString("gioi_tinh"));
                n.setDiaChi(rs.getString("dia_chi"));
                n.setSoDienThoai(rs.getString("so_dien_thoai"));
                n.setVitriId(rs.getString("vitri_id"));
                return n;
            }
        });
    }
}
