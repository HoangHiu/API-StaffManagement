package Nhom5_API.QuanLyNhanSu.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;

import Nhom5_API.QuanLyNhanSu.beans.KhoaHocDAO;
import Nhom5_API.QuanLyNhanSu.beans.BaiHocDAO;
import Nhom5_API.QuanLyNhanSu.model.BaiHocObj;
import Nhom5_API.QuanLyNhanSu.model.KhoaHocObj;


@RestController
public class KhoaHocController {

    private class returnKhoaHoc{
        private KhoaHocObj infoKhoaHoc;
        private List<BaiHocObj> listBaiHoc;

        public returnKhoaHoc(){};

        public returnKhoaHoc(KhoaHocObj khoaHoc, List<BaiHocObj> listBaiHoc){
            this.infoKhoaHoc = khoaHoc;
            this.listBaiHoc = listBaiHoc;
        }

        public KhoaHocObj getInfoKhoaHoc() {
            return infoKhoaHoc;
        }
        public void setInfoKhoaHoc(KhoaHocObj infoKhoaHoc) {
            this.infoKhoaHoc = infoKhoaHoc;
        }
        public List<BaiHocObj> getListBaiHoc() {
            return listBaiHoc;
        }
        public void setListBaiHoc(List<BaiHocObj> listBaiHoc) {
            this.listBaiHoc = listBaiHoc;
        }
    }

    KhoaHocDAO khoaHocDAO = new KhoaHocDAO();
    BaiHocDAO baiHocDAO = new BaiHocDAO();

    private List<KhoaHocObj> listKhoaHoc = new ArrayList<KhoaHocObj>();
    
    @GetMapping("/KhoaHoc")
    public List<KhoaHocObj> getListKhoaHoc(){
        listKhoaHoc = khoaHocDAO.getAllKhoaHoc();
        return listKhoaHoc;
    }

    @GetMapping("/KhoaHoc/search/name={name}")
    public List<KhoaHocObj> searchListKhoaHoc(@PathVariable String name){
        listKhoaHoc = khoaHocDAO.searchListKhoaHoc(name);
        return listKhoaHoc;
    }

    @GetMapping("/KhoaHoc/info/id={id}")
    public returnKhoaHoc infoKhoaHoc(@PathVariable String id){
        KhoaHocObj infoKhoaHoc = khoaHocDAO.getKhoaHoc(id);
        List<BaiHocObj> listBaiHoc = baiHocDAO.getListBaiHocFromIdKhoaHoc(id);
        
        returnKhoaHoc returnKhoaHoc = new returnKhoaHoc(infoKhoaHoc, listBaiHoc);

        return returnKhoaHoc;
    }

    // add khoa hoc
    @PostMapping("/KhoaHoc")
    public void createKhoaHoc(@RequestBody KhoaHocObj khoaHoc){
        khoaHocDAO.addKhoaHoc(khoaHoc);
    }

    // update khoa hoc
    @PutMapping("/KhoaHoc")
    public KhoaHocObj updateNhanVien(@RequestBody KhoaHocObj khoaHoc){
        khoaHocDAO.updateKhoaHoc(khoaHoc);
        return khoaHoc;
    }

    // delete khoa hoc
    @DeleteMapping("/KhoaHoc/id={id}")
    public String deleteNhanVien(@PathVariable String id){
        khoaHocDAO.deleteKhoaHoc(id);
        baiHocDAO.deleteAllBaiHocFromKhoaHoc(id);
        return id;
    }
}
