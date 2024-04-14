package Nhom5_API.QuanLyNhanSu.model;

public class NhanVienObj {
    private String id;
    private String HoTen;
    private String NgaySinh;
    private String QueQuan;
    private String GioiTinh;
    private String SoDT;
    private String MaPhongBan;
    private String MaChucVu;

    public NhanVienObj(){}

    public NhanVienObj(String id, String HoTen, String NgaySinh, String QueQuan, String GioiTinh, String SoDT, String MaPhongBan, String MaChucVu){
        this.id = id;
        this.HoTen = HoTen;
        this.NgaySinh = NgaySinh;
        this.QueQuan = QueQuan;
        this.GioiTinh = GioiTinh;
        this.SoDT = SoDT;
        this.MaPhongBan = MaPhongBan;
        this.MaChucVu = MaChucVu;
    }
    //Getters and Setters
    public String getId(){
        return id;
    }
    public String getHoTen(){
        return HoTen;
    }
    public String getNgaySinh(){
        return NgaySinh;
    }
    public String getQueQuan(){
        return QueQuan;
    }
    public String getGioiTinh(){
        return GioiTinh;
    }
    public String getSoDT(){
        return SoDT;
    }
    public String getMaPhongBan(){
        return MaPhongBan;
    }
    public String getMaChucVu(){
        return MaChucVu;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setHoTen(String HoTen) {
        this.HoTen = HoTen;
    }
    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }
    public void setQueQuan(String QueQuan) {
        this.QueQuan = QueQuan;
    }
    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }
    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }
    public void setMaPhongBan(String MaPhongBan) {
        this.MaPhongBan = MaPhongBan;
    }
    public void setMaChucVu(String MaChucVu) {
        this.MaChucVu = MaChucVu;
    }

}
