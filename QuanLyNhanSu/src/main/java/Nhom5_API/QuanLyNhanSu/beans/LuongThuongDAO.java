package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.LuongThuongObj;
import jakarta.ejb.Stateless;

@Stateless
public class LuongThuongDAO {
    public List<LuongThuongObj> getListLuong() {
        List<LuongThuongObj> listLuong = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection()
            ) {
                String sqlQuery = "SELECT * FROM LUONGTHUONG";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while (res.next()) {
                    LuongThuongObj luong = new LuongThuongObj(
                            res.getString(1),
                            res.getInt(2),
                            res.getInt(3),
                            res.getInt(4),
                            res.getInt(5),
                            res.getString(6),
                            res.getString(7)
                    );
                    listLuong.add(luong);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listLuong;
    }

    public List<LuongThuongObj> getSearchListLuong(String id) {
        List<LuongThuongObj> listLuong = new ArrayList<>();
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection()
            ) {
                String sqlQuery = "SELECT * FROM LUONGTHUONG where MaNhanVien = ?";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                prst.setString(1,id);
                ResultSet res = prst.executeQuery();

                while (res.next()) {
                    LuongThuongObj luong = new LuongThuongObj(
                            res.getString(1),
                            res.getInt(2),
                            res.getInt(3),
                            res.getInt(4),
                            res.getInt(5),
                            res.getString(6),
                            res.getString(7)
                    );
                    listLuong.add(luong);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listLuong;
    }

    public void addBangLuong(LuongThuongObj Luong){
        int dupecheck = dupecheck(Luong);
        int validUserCheck = validUserCheck(Luong);

        if (dupecheck == 1 && validUserCheck == 1){
            String sqlCommand = "INSERT INTO LUONGTHUONG (MaLuong, MaNhanVien, LuongCoBan, LuongThuong, " +
                    "PhuCap, KhauHao, NgayTinhLuong, luongThucLanh) values (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)){

                pstmt.setString(1,Luong.getMaLuong());
                pstmt.setString(2, Luong.getMaNhanVien());
                pstmt.setInt(3, Luong.getLuongCoBan());
                pstmt.setInt(4, Luong.getLuongThuong());
                pstmt.setInt(5, Luong.getPhuCap());
                pstmt.setInt(6, Luong.getKhauHao());
                pstmt.setString(7, Luong.getNgayTinhLuong());
                pstmt.setInt(8, Luong.getLuongThucLanh());

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else {
            String message = "Add Salary unsuccessfully";
        }
    }

    public void updateBangLuong(LuongThuongObj Luong) {
        String sqlCommand = "UPDATE LUONGTHUONG set LuongCoBan = ?, PhuCap = ?, LuongThuong = ?, KhauHao = ?, NgayTinhLuong = ?, MaNhanVien = ? where MaLuong = ?";
        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setInt(1, Luong.getLuongCoBan());
            pstmt.setInt(2, Luong.getPhuCap());
            pstmt.setInt(3, Luong.getLuongThuong());
            pstmt.setInt(4, Luong.getKhauHao());
            pstmt.setString(5, Luong.getNgayTinhLuong());
            pstmt.setString(6, Luong.getMaNhanVien());
            pstmt.setString(7, Luong.getMaLuong());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deleteLuong(String id) {
        String sqlCommand = "DELETE FROM LUONGTHUONG where MaLuong = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void deleteLuongFromNhanVien(String id) {
        String sqlCommand = "DELETE FROM LUONGTHUONG where MaNhanVien = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, id);
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int dupecheck(LuongThuongObj Luong) {
        if (Luong.getMaLuong() == null  || Luong.getMaNhanVien() == null ){
            System.out.println("info cant be empty !");
            return 0;
        }
        String sql = "SELECT * FROM LUONGTHUONG WHERE MaLuong = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, Luong.getMaLuong());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 1;
    }

    public int validUserCheck(LuongThuongObj Luong) {
        if (Luong.getMaLuong() == null  || Luong.getMaNhanVien() == null ){
            System.out.println("info cant be empty !");
            return 0;
        }
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, Luong.getMaNhanVien());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 1;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }
}
