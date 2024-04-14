package Nhom5_API.QuanLyNhanSu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Nhom5_API.QuanLyNhanSu.beans.HieuSuatDAO;
import Nhom5_API.QuanLyNhanSu.beans.LuongThuongDAO;
import Nhom5_API.QuanLyNhanSu.beans.NhanVienDAO;
import Nhom5_API.QuanLyNhanSu.model.NhanVienObj;

@RestController
public class NhanVienController {
    NhanVienDAO nhanVienDAO = new NhanVienDAO();
    HieuSuatDAO hieuSuatDAO = new HieuSuatDAO();
    LuongThuongDAO luongThuongDAO = new LuongThuongDAO();

    private List<NhanVienObj> listNhanVien = new ArrayList<NhanVienObj>();

    @GetMapping("/NhanVien")
    public List<NhanVienObj> getListNhanVien(){
        listNhanVien = nhanVienDAO.getListNhanVien();
        return listNhanVien;
    }

    @GetMapping("/NhanVien/search/name={name}")
    public List<NhanVienObj> searchListNhanVien(@PathVariable String name){
        listNhanVien = nhanVienDAO.searchListNhanVien(name);
        return listNhanVien;
    }

    @GetMapping("/NhanVien/info/id={id}")
    public NhanVienObj infoNhanVien(@PathVariable String id){
        NhanVienObj infoNhanVien = nhanVienDAO.getNhanVIen(id);
        return infoNhanVien;
    }

    // add nhan vien
    @PostMapping("/NhanVien")
    public void createNhanVien(@RequestBody NhanVienObj nhanVien){
        nhanVienDAO.addNhanVien(nhanVien);
    }

    // update nhan vien
    @PutMapping("/NhanVien")
    public NhanVienObj updateNhanVien(@RequestBody NhanVienObj nhanVien){
        nhanVienDAO.updateNhanVien(nhanVien);
        return nhanVien;
    }

    // delete nhan vien
    @DeleteMapping("/NhanVien/id={id}")
    public String deleteNhanVien(@PathVariable String id){
        nhanVienDAO.deleteNhanVien(id);
        hieuSuatDAO.deleteAllHieuSuatFromNhanVien(id);
        luongThuongDAO.deleteLuongFromNhanVien(id);
        return id;
    }
}
