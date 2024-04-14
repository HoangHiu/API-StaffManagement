package Nhom5_API.QuanLyNhanSu.model;

public class HieuSuatObj {
    private String id;
    private int KyNang;
    private int ThaiDo;
    private int NangLuc;
    private int HieuSuatThuc;
    private String ThoiGianDanhGia;
    private String MaNhanVien;

    public HieuSuatObj(){}

    public HieuSuatObj(String id, int KyNang, int ThaiDo, int NangLuc, String ThoiGianDanhGia, String MaNhanVien){
        this.id = id;
        this.KyNang = KyNang;
        this.ThaiDo = ThaiDo;
        this.NangLuc = NangLuc;
        this.HieuSuatThuc = calcHieuSuatThuc();
        this.ThoiGianDanhGia = ThoiGianDanhGia;
        this.MaNhanVien = MaNhanVien;
    }

    public int calcHieuSuatThuc(){
        int kqHieuSuatThuc = this.KyNang + this.ThaiDo + this.NangLuc;
        return kqHieuSuatThuc;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public int getKyNang() {
        return KyNang;
    }

    public void setKyNang(int kyNang) {
        KyNang = kyNang;
    }

    public int getThaiDo() {
        return ThaiDo;
    }

    public void setThaiDo(int thaiDo) {
        ThaiDo = thaiDo;
    }

    public int getNangLuc() {
        return NangLuc;
    }

    public void setNangLuc(int nangLuc) {
        NangLuc = nangLuc;
    }

    public int getHieuSuatThuc() {
        return HieuSuatThuc;
    }

    public void setHieuSuatThuc(int hieuSuatThuc) {
        HieuSuatThuc = hieuSuatThuc;
    }

    public String getThoiGianDanhGia() {
        return ThoiGianDanhGia;
    }

    public void setThoiGianDanhGia(String thoiGianDanhGia) {
        ThoiGianDanhGia = thoiGianDanhGia;
    }

    public String getMaNhanVien() {
        return MaNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        MaNhanVien = maNhanVien;
    }
}
