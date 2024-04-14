package Nhom5_API.QuanLyNhanSu.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.beans.HieuSuatDAO;
import Nhom5_API.QuanLyNhanSu.model.HieuSuatObj;


@RestController
public class HieuSuatController {
    HieuSuatDAO hieuSuatDAO = new HieuSuatDAO();

    private List<HieuSuatObj> listHieuSuat = new ArrayList<HieuSuatObj>();

    @GetMapping("/hieuSuat")
    public List<HieuSuatObj> getListLuong() {
        listHieuSuat = hieuSuatDAO.getAllHieuSuat();
        return listHieuSuat;
    }
    
    @GetMapping("/hieuSuat/idNhanVien={id}")
    public List<HieuSuatObj> getSearchLuong(@PathVariable String id) {
        listHieuSuat = hieuSuatDAO.getListHieuSuatEmployee(id);
        return listHieuSuat;
    }

    @PostMapping("/hieuSuat")
    public void postAddLuong(@RequestBody HieuSuatObj hieuSuat) {
        hieuSuat.setHieuSuatThuc(hieuSuat.calcHieuSuatThuc());;
        hieuSuatDAO.addHieuSuat(hieuSuat);
    }
    
    @PutMapping("/hieuSuat")
    public HieuSuatObj putUpdateLuong(@RequestBody HieuSuatObj hieuSuat) {
        hieuSuat.setHieuSuatThuc(hieuSuat.calcHieuSuatThuc());;
        hieuSuatDAO.updateHieuSuat(hieuSuat);
        return hieuSuat;
    }

    @DeleteMapping("/hieuSuat/idHieuSuat={id}")
    public String deleteHieuSuat(@PathVariable String id){
        hieuSuatDAO.deleteHieuSuat(id);
        return id;
    }
}
