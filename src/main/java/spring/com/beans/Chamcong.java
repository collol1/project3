package spring.com.beans;

import java.time.LocalDate;

public class Chamcong {
    private String chamcongId;
    private String nhanvienId;  // Thay vì lưu đối tượng, chỉ lưu ID nhân viên
    private LocalDate ngay;
    private int soGioLam;

    public Chamcong() {
        super();
    }

    public Chamcong(String chamcongId, String nhanvienId, LocalDate ngay, int soGioLam) {
        super();
        this.chamcongId = chamcongId;
        this.nhanvienId = nhanvienId;
        this.ngay = ngay;
        this.soGioLam = soGioLam;
    }

    public String getChamcongId() {
        return chamcongId;
    }

    public void setChamcongId(String chamcongId) {
        this.chamcongId = chamcongId;
    }

    public String getNhanvienId() {
        return nhanvienId;
    }

    public void setNhanvienId(String nhanvienId) {
        this.nhanvienId = nhanvienId;
    }

    public LocalDate getNgay() {
        return ngay;
    }

    public void setNgay(LocalDate ngay) {
        this.ngay = ngay;
    }

    public int getSoGioLam() {
        return soGioLam;
    }

    public void setSoGioLam(int soGioLam) {
        this.soGioLam = soGioLam;
    }
}
