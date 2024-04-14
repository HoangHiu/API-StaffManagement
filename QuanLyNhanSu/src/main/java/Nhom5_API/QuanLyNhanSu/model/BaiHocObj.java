package Nhom5_API.QuanLyNhanSu.model;

public class BaiHocObj {
    private String id;
    private String TenBaiHoc;
    private String NoiDung;
    private String MoTa;
    private String MaKhoaHoc;

    public BaiHocObj(){}

    public BaiHocObj(String id, String TenBaiHoc, String NoiDung, String MoTa, String MaKhoaHoc){
        this.id = id;
        this.TenBaiHoc = TenBaiHoc;
        this.NoiDung = NoiDung;
        this.MoTa = MoTa;
        this.MaKhoaHoc = MaKhoaHoc;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getMaKhoaHoc() {
        return MaKhoaHoc;
    }

    public void setMaKhoaHoc(String maKhoaHoc) {
        MaKhoaHoc = maKhoaHoc;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String moTa) {
        MoTa = moTa;
    }

    public String getNoiDung() {
        return NoiDung;
    }

    public void setNoiDung(String noiDung) {
        NoiDung = noiDung;
    }

    public String getTenBaiHoc() {
        return TenBaiHoc;
    }

    public void setTenBaiHoc(String tenBaiHoc) {
        TenBaiHoc = tenBaiHoc;
    }
}
