package Nhom5_API.QuanLyNhanSu.model;

public class ChucVuObj {
    private String id;
    private String TenChucVu;

    public ChucVuObj(){}

    public ChucVuObj(String id, String TenChucVu){
        this.id = id;
        this.TenChucVu = TenChucVu;
    }

    public String getTenChucVu() {
        return TenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        TenChucVu = tenChucVu;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
