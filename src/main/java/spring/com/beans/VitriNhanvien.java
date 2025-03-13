package spring.com.beans;

public class VitriNhanvien {
    private String vitriId;
    private String tenViTri;
    private double luongCoBan;

    public VitriNhanvien() {
        super();
    }

    public VitriNhanvien(String vitriId, String tenViTri, double luongCoBan) {
        super();
        this.vitriId = vitriId;
        this.tenViTri = tenViTri;
        this.luongCoBan = luongCoBan;
    }

    public String getVitriId() {
        return vitriId;
    }

    public void setVitriId(String vitriId) {
        this.vitriId = vitriId;
    }

    public String getTenViTri() {
        return tenViTri;
    }

    public void setTenViTri(String tenViTri) {
        this.tenViTri = tenViTri;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }
}
