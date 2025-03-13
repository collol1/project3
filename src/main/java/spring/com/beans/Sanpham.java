package spring.com.beans;

public class Sanpham {
    private String sanphamId;
    private String tenSanPham;
    private int soLuongTon;
    private int soLuongBan;
    private double gia;

    public Sanpham() {
        super();
    }

    public Sanpham(String sanphamId, String tenSanPham, int soLuongTon, int soLuongBan, double gia) {
        super();
        this.sanphamId = sanphamId;
        this.tenSanPham = tenSanPham;
        this.soLuongTon = soLuongTon;
        this.soLuongBan = soLuongBan;
        this.gia = gia;
    }

    public String getSanphamId() {
        return sanphamId;
    }

    public void setSanphamId(String sanphamId) {
        this.sanphamId = sanphamId;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public int getSoLuongBan() {
        return soLuongBan;
    }

    public void setSoLuongBan(int soLuongBan) {
        this.soLuongBan = soLuongBan;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }
}
