package Nhom5_API.QuanLyNhanSu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Nhom5_API.QuanLyNhanSu.beans.LuongThuongDAO;
import Nhom5_API.QuanLyNhanSu.model.LuongThuongObj;


@RestController
public class LuongController {
    LuongThuongDAO luongThuongDAO = new LuongThuongDAO();

    private List<LuongThuongObj> listLuong = new ArrayList<LuongThuongObj>();

    @GetMapping("/luongThuong")
    public List<LuongThuongObj> getListLuong() {
        listLuong = luongThuongDAO.getListLuong();
        return listLuong;
    }
    
    @GetMapping("/luongThuong/idNhanVien={id}")
    public List<LuongThuongObj> getSearchLuong(@PathVariable String id) {
        listLuong = luongThuongDAO.getSearchListLuong(id);
        return listLuong;
    }

    @PostMapping("/luongThuong")
    public void postAddLuong(@RequestBody LuongThuongObj luong) {
        luong.setLuongThucLanh(luong.total());
        luongThuongDAO.addBangLuong(luong);
    }
    
    @PutMapping("/luongThuong")
    public LuongThuongObj putUpdateLuong(@RequestBody LuongThuongObj luong) {
        luong.setLuongThucLanh(luong.total());
        luongThuongDAO.updateBangLuong(luong);
        return luong;
    }

    @DeleteMapping("/luongThuong/idLuong={id}")
    public String deleteBangLuong(@PathVariable String id){
        luongThuongDAO.deleteLuong(id);
        return id;
    }
}
