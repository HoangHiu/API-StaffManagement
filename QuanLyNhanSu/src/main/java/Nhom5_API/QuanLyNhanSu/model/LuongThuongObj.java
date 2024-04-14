package Nhom5_API.QuanLyNhanSu.model;

public class LuongThuongObj {
    
    private String maLuong;
    private int luongCoBan;
    private int phuCap;
    private int luongThuong;
    private int khauHao;
    private String ngayTinhLuong;
    private String maNhanVien;
    private int luongThucLanh; 

    //constructer
    public LuongThuongObj() {
    }

    public LuongThuongObj(String MaLuong, int LuongCoBan, int PhuCap, int LuongThuong, int KhauHao, String NgayTinhLuong, String MaNhanVien) {
        maLuong = MaLuong;
        luongCoBan = LuongCoBan;
        phuCap = PhuCap;
        luongThuong = LuongThuong;
        khauHao = KhauHao;
        ngayTinhLuong = NgayTinhLuong;
        maNhanVien = MaNhanVien;
        luongThucLanh = this.total();
    }

    public int total(){
        int TongLuong = luongCoBan + phuCap + luongThuong - khauHao;
        return TongLuong;
    }

    //getter and setter
    public String getMaLuong() {
        return maLuong;
    }

    public void setMaLuong(String maLuong) {
        this.maLuong = maLuong;
    }

    public int getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(int luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    public int getPhuCap() {
        return phuCap;
    }

    public void setPhuCap(int phuCap) {
        this.phuCap = phuCap;
    }

    public int getLuongThuong() {
        return luongThuong;
    }

    public void setLuongThuong(int luongThuong) {
        this.luongThuong = luongThuong;
    }

    public int getKhauHao() {
        return khauHao;
    }

    public void setKhauHao(int khauHao) {
        this.khauHao = khauHao;
    }

    public String getNgayTinhLuong() {
        return ngayTinhLuong;
    }

    public void setNgayTinhLuong(String ngayTinhLuong) {
        this.ngayTinhLuong = ngayTinhLuong;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getLuongThucLanh() {
        return luongThucLanh;
    }

    public void setLuongThucLanh(int luongThucLanh) {
        this.luongThucLanh = luongThucLanh;
    }


}
