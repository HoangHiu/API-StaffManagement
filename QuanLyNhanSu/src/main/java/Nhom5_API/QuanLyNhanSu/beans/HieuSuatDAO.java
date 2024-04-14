package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.HieuSuatObj;
import jakarta.ejb.Stateless;

@Stateless
public class HieuSuatDAO {
    public int checkID(HieuSuatObj HieuSuat){
        if (HieuSuat.getId() == null || HieuSuat.getKyNang() > 15 || HieuSuat.getThaiDo() > 15 || HieuSuat.getNangLuc() > 15 || HieuSuat.getThoiGianDanhGia().isEmpty() || HieuSuat.getMaNhanVien().isEmpty()) {
            System.out.println("Info cannot be empty.");
            return 0;
        }
        String sql = "SELECT * FROM HIEUSUAT WHERE MaHieuSuat = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, HieuSuat.getId());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 1;
    }
    public int checkIDNhanVien(HieuSuatObj HieuSuat){
        if (HieuSuat.getId() == null || HieuSuat.getKyNang() > 15 || HieuSuat.getThaiDo() > 15 || HieuSuat.getNangLuc() > 15 || HieuSuat.getThoiGianDanhGia().isEmpty() || HieuSuat.getMaNhanVien().isEmpty()) {
            System.out.println("Info cannot be empty.");
            return 0;
        }
        String sql = "SELECT * FROM NHANVIEN WHERE MaNhanVien = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, HieuSuat.getMaNhanVien());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 1;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 0;
    }

    public List<HieuSuatObj> getAllHieuSuat() {
        List<HieuSuatObj> listHieuSuat = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from HIEUSUAT";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while (res.next()) {
                    HieuSuatObj HieuSuat = new HieuSuatObj(
                            res.getString(1),
                            res.getInt(2),
                            res.getInt(3),
                            res.getInt(7),
                            res.getString(4),
                            res.getString(6)
                    );
                    listHieuSuat.add(HieuSuat);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listHieuSuat;
    }

    public List<HieuSuatObj> getListHieuSuatFromIdNhanVien(String id){
        List<HieuSuatObj> listHieuSuat = new ArrayList<>();
        String sqlComm = "Select * FROM HIEUSUAT WHERE MaNhanVien = ?";


        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlComm)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                HieuSuatObj HieuSuat = new HieuSuatObj();

                HieuSuat.setId(rs.getString(1));
                HieuSuat.setKyNang(rs.getInt(2));
                HieuSuat.setThaiDo(rs.getInt(3));
                HieuSuat.setNangLuc(rs.getInt(7));
                HieuSuat.setThoiGianDanhGia(rs.getString(4));
                HieuSuat.setMaNhanVien(rs.getString(6));
                HieuSuat.setHieuSuatThuc(HieuSuat.calcHieuSuatThuc());


                listHieuSuat.add(HieuSuat);
            }

            return listHieuSuat;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listHieuSuat;
    }
    
    public List<HieuSuatObj> getListHieuSuatEmployee(String id){
        List<HieuSuatObj> listHieuSuat = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from HieuSuat where MaNhanVien = ?";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                prst.setString(1, id);

                ResultSet res = prst.executeQuery();

                while (res.next()){
                    HieuSuatObj HieuSuat = new HieuSuatObj();
                    HieuSuat.setId(res.getString(1));
                    HieuSuat.setKyNang(res.getInt(2));
                    HieuSuat.setThaiDo(res.getInt(3));
                    HieuSuat.setNangLuc(res.getInt(7));
                    HieuSuat.setThoiGianDanhGia(res.getString(4));
                    HieuSuat.setMaNhanVien(res.getString(6));
                    HieuSuat.setHieuSuatThuc(HieuSuat.calcHieuSuatThuc());

                    listHieuSuat.add(HieuSuat);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listHieuSuat;
    }

    public void addHieuSuat(HieuSuatObj HieuSuat) {
        String sqlCommand = "INSERT INTO HIEUSUAT (MaHieuSuat, KyNang, ThaiDo, ThoiGianDanhGia, HieuSuatThuc, MaNhanVien, NangLuc) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, HieuSuat.getId());
            pstmt.setInt(2, HieuSuat.getKyNang());
            pstmt.setInt(3, HieuSuat.getThaiDo());
            pstmt.setString(4, HieuSuat.getThoiGianDanhGia());
            pstmt.setInt(5, HieuSuat.getHieuSuatThuc());
            pstmt.setString(6, HieuSuat.getMaNhanVien());
            pstmt.setInt(7, HieuSuat.getNangLuc());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateHieuSuat(HieuSuatObj HieuSuat){
        String sqlCommand = "UPDATE HIEUSUAT set KyNang = ?, ThaiDo = ?, ThoiGianDanhGia = ?, HieuSuatThuc = ?, NangLuc = ? where MaHieuSuat = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setInt(1, HieuSuat.getKyNang());
            pstmt.setInt(2, HieuSuat.getThaiDo());
            pstmt.setString(3, HieuSuat.getThoiGianDanhGia());
            pstmt.setInt(4, HieuSuat.getHieuSuatThuc());
            pstmt.setInt(5, HieuSuat.getNangLuc());
            pstmt.setString(6, HieuSuat.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteHieuSuat(String id){
        String sqlCommand = "DELETE FROM HIEUSUAT where MaHieuSuat = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteAllHieuSuatFromNhanVien(String id){
        String sqlCommand = "DELETE FROM HieuSuat where MaNhanVien = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, id);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
