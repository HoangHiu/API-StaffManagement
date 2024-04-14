package Nhom5_API.QuanLyNhanSu.model;

public class KhoaHocObj {
    private String id;
    private String TenKhoaHoc;
    private String TenGiangVien;
    private String MoTaKhoaHoc;
    private String AnhKhoaHoc;
    private String ThoiGianHoc;
    private String DoKho;

    public KhoaHocObj(){}

    public KhoaHocObj(String id, String TenKhoaHoc, String TenGiangVien, String MoTaKhoaHoc, String AnhKhoaHoc, String ThoiGianHoc, String DoKho){
        this.id = id;
        this.TenKhoaHoc = TenKhoaHoc;
        this.TenGiangVien = TenGiangVien;
        this.MoTaKhoaHoc = MoTaKhoaHoc;
        this.AnhKhoaHoc = AnhKhoaHoc;
        this.ThoiGianHoc = ThoiGianHoc;
        this.DoKho = DoKho;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getTenKhoaHoc() {
        return TenKhoaHoc;
    }

    public void setTenKhoaHoc(String tenKhoaHoc) {
        TenKhoaHoc = tenKhoaHoc;
    }

    public String getTenGiangVien() {
        return TenGiangVien;
    }

    public void setTenGiangVien(String tenGiangVien) {
        TenGiangVien = tenGiangVien;
    }

    public String getMoTaKhoaHoc() {
        return MoTaKhoaHoc;
    }

    public void setMoTaKhoaHoc(String moTaKhoaHoc) {
        MoTaKhoaHoc = moTaKhoaHoc;
    }

    public String getAnhKhoaHoc() {
        return AnhKhoaHoc;
    }

    public void setAnhKhoaHoc(String anhKhoaHoc) {
        AnhKhoaHoc = anhKhoaHoc;
    }

    public String getThoiGianHoc() {
        return ThoiGianHoc;
    }

    public void setThoiGianHoc(String thoiGianHoc) {
        ThoiGianHoc = thoiGianHoc;
    }

    public String getDoKho() {
        return DoKho;
    }

    public void setDoKho(String doKho) {
        DoKho = doKho;
    }
}
