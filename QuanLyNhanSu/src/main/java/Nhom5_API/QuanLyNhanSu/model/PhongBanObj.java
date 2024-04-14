package Nhom5_API.QuanLyNhanSu.model;

import java.util.Objects;

public class PhongBanObj {
    private String id;
    private String TenPhongBan;
    private String DiaChi;
    private String SoDT;

    public PhongBanObj(){}

    public PhongBanObj(String id, String TenPhongBan, String DiaChi, String SoDT){
        this.id = id;
        this.TenPhongBan = TenPhongBan;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
    }

    public String getTenPhongBan() {
        return TenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        TenPhongBan = tenPhongBan;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String soDT) {
        SoDT = soDT;
    }
}
