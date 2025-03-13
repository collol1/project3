package spring.com.beans;

public class Nhamay {
    private String nhamayId;
    private String tenNhaMay;
    private String diaChi;
    private String soDienThoai;

    public Nhamay() {
        super();
    }

    public Nhamay(String nhamayId, String tenNhaMay, String diaChi, String soDienThoai) {
        super();
        this.nhamayId = nhamayId;
        this.tenNhaMay = tenNhaMay;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
    }

    public String getNhamayId() {
        return nhamayId;
    }

    public void setNhamayId(String nhamayId) {
        this.nhamayId = nhamayId;
    }

    public String getTenNhaMay() {
        return tenNhaMay;
    }

    public void setTenNhaMay(String tenNhaMay) {
        this.tenNhaMay = tenNhaMay;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }
}
