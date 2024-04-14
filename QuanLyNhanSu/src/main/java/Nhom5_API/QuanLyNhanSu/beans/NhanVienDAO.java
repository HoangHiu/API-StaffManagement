package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.NhanVienObj;
import jakarta.ejb.Stateless;

@Stateless
public class NhanVienDAO {
    public List<NhanVienObj> searchListNhanVien(String name){
        List<NhanVienObj> listNhanVien = new ArrayList<NhanVienObj>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from NHANVIEN where hoTen LIKE '% " + name + "%' ";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while(res.next()){
                    NhanVienObj NhanVien = new NhanVienObj(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getString(7),
                            res.getString(8)
                    );
                    listNhanVien.add(NhanVien);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listNhanVien;
    }


    public NhanVienObj getNhanVIen(String id){
        NhanVienObj nhanvien = new NhanVienObj();

        String sqlComm = "Select * FROM NHANVIEN WHERE MaNV = ?";


        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlComm)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                nhanvien.setId(rs.getString(1));
                nhanvien.setHoTen(rs.getString(2));
                nhanvien.setNgaySinh(rs.getString(3));
                nhanvien.setQueQuan(rs.getString(4));
                nhanvien.setGioiTinh(rs.getString(5));
                nhanvien.setSoDT(rs.getString(6));
                nhanvien.setMaPhongBan(rs.getString(7));
                nhanvien.setMaChucVu(rs.getString(8));
            }

            return nhanvien;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return nhanvien;
    }

    public int checkID(NhanVienObj NhanVien){
        // Check if either username or password is empty
        if (NhanVien.getId() == null || NhanVien.getHoTen().isEmpty() || NhanVien.getSoDT().isEmpty() || NhanVien.getQueQuan().isEmpty() || NhanVien.getNgaySinh().isEmpty()) {
            System.out.println("Info cannot be empty.");
            return 0;
        }
        String sql = "SELECT * FROM NHANVIEN WHERE MaNV = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, NhanVien.getId());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 1;
    }


    public List<NhanVienObj> getListNhanVien(){
        List<NhanVienObj> listNhanVien = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from NHANVIEN";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while(res.next()){
                    NhanVienObj NhanVien = new NhanVienObj(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getString(7),
                            res.getString(8)
                    );
                    listNhanVien.add(NhanVien);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listNhanVien;
    }

    public void  addNhanVien(NhanVienObj NhanVien){
        int idCheck = checkID(NhanVien);

        if (idCheck==1){
            String sqlCommand = "INSERT INTO NHANVIEN (MaNV, HoTen, NgaySinh, QueQuan, GioiTinh, SoDT, MaPhongBan, MaChucVu) values (?, ?, ?, ?, ?, ?, ?, ?)";

            try (Connection conn = connectDB.getConnection();
                PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

                pstmt.setString(1, NhanVien.getId());
                pstmt.setString(2, NhanVien.getHoTen());
                pstmt.setString(3, NhanVien.getNgaySinh());
                pstmt.setString(4, NhanVien.getQueQuan());
                pstmt.setString(5, NhanVien.getGioiTinh());
                pstmt.setString(6, NhanVien.getSoDT());
                pstmt.setString(7, NhanVien.getMaPhongBan());
                pstmt.setString(8, NhanVien.getMaChucVu());

                pstmt.executeUpdate();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }else{
            String message = "Add Employee unsuccessfully";
        }
    }

    public void updateNhanVien(NhanVienObj NhanVien){
        String sqlCommand = "UPDATE NHANVIEN set  HoTen = ?, NgaySinh = ?, QueQuan = ?, GioiTinh = ?, SoDT = ?, MaPhongBan = ?, MaChucVu= ? where MaNV = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, NhanVien.getHoTen());
            pstmt.setString(2, NhanVien.getNgaySinh());
            pstmt.setString(3, NhanVien.getQueQuan());
            pstmt.setString(4, NhanVien.getGioiTinh());
            pstmt.setString(5, NhanVien.getSoDT());
            pstmt.setString(6, NhanVien.getMaPhongBan());
            pstmt.setString(7, NhanVien.getMaChucVu());
            pstmt.setString(8, NhanVien.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteNhanVien(String id){
        String sqlCommand = "DELETE FROM NHANVIEN where MaNV = ?";

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
