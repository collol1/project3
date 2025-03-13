package spring.com.beans;

public class Luong {
    private String luongId;
    private String nhanvienId;
    private int thang;
    private int nam;
    private int tongGioLam;
    private double luongThang;

    public Luong() {
        super();
    }

    public Luong(String luongId, String nhanvienId, int thang, int nam, int tongGioLam, double luongThang) {
        super();
        this.luongId = luongId;
        this.nhanvienId = nhanvienId;
        this.thang = thang;
        this.nam = nam;
        this.tongGioLam = tongGioLam;
        this.luongThang = luongThang;
    }

    public String getLuongId() {
        return luongId;
    }

    public void setLuongId(String luongId) {
        this.luongId = luongId;
    }

    public String getNhanvienId() {
        return nhanvienId;
    }

    public void setNhanvienId(String nhanvienId) {
        this.nhanvienId = nhanvienId;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public int getTongGioLam() {
        return tongGioLam;
    }

    public void setTongGioLam(int tongGioLam) {
        this.tongGioLam = tongGioLam;
    }

    public double getLuongThang() {
        return luongThang;
    }

    public void setLuongThang(double luongThang) {
        this.luongThang = luongThang;
    }
}
