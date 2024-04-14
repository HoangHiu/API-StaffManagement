package Nhom5_API.QuanLyNhanSu.controller;


import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.beans.BaiHocDAO;
import Nhom5_API.QuanLyNhanSu.model.BaiHocObj;


@RestController
public class BaiHocController {

    List<BaiHocObj> listBaiHoc = new ArrayList<BaiHocObj>();

    BaiHocDAO baiHocDAO = new BaiHocDAO();

    @GetMapping("/BaiHoc/search/name={name}")
    public List<BaiHocObj> searchBaiHoc(@PathVariable String name) {
        listBaiHoc = baiHocDAO.searchListBaiHoc(name);
        return listBaiHoc;
    }

    @GetMapping("/BaiHoc/id={id}/info")
    public BaiHocObj getInfoBaiHoc(@PathVariable String id) {
        BaiHocObj baiHocInfo = baiHocDAO.getBaiHoc(id);
        return baiHocInfo;
    }

    @PostMapping("/BaiHoc")
    public void postAddBaiHoc(@RequestBody BaiHocObj baiHoc) {
        baiHocDAO.addBaiHoc(baiHoc);
    }
    
    @PutMapping("/BaiHoc")
    public BaiHocObj putUpdateBaiHoc(@RequestBody BaiHocObj baiHoc) {
        baiHocDAO.updateBaiHoc(baiHoc);
        return baiHoc;
    }

    @DeleteMapping("/BaiHoc/idBaiHoc={id}")
    public String deleteBaiHoc(@PathVariable String id){
        baiHocDAO.deleteBaiHoc(id);
        return id;
    }
}
