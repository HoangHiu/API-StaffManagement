package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.KhoaHocObj;
import jakarta.ejb.Stateless;

@Stateless
public class KhoaHocDAO {
    BaiHocDAO baiHocDAO = new BaiHocDAO();

    public List<KhoaHocObj> searchListKhoaHoc(String name){
        List<KhoaHocObj> listKhoaHoc = new ArrayList<KhoaHocObj>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from KHOAHOC where TenKhoaHoc LIKE '% " + name + "%' ";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while(res.next()){
                    KhoaHocObj KhoaHoc = new KhoaHocObj(
                        res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(4),
                        res.getString(5),
                        res.getString(6),
                        res.getString(7)
                    );
                    listKhoaHoc.add(KhoaHoc);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listKhoaHoc;
    }
    
    public int checkID(KhoaHocObj KhoaHoc) {
        // Check if either username or password is empty
        if (KhoaHoc.getId() == null || KhoaHoc.getTenKhoaHoc().isEmpty() || KhoaHoc.getTenGiangVien().isEmpty() || KhoaHoc.getMoTaKhoaHoc().isEmpty() || KhoaHoc.getThoiGianHoc().isEmpty() || KhoaHoc.getDoKho().isEmpty()) {
            System.out.println("Info cannot be empty.");
            return 0;
        }
        String sql = "SELECT * FROM KHOAHOC WHERE MaKhoaHoc = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, KhoaHoc.getId());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 1;
    }

    public List<KhoaHocObj> getAllKhoaHoc() {
        List<KhoaHocObj> listKhoaHoc = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from KHOAHOC";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while (res.next()) {
                    KhoaHocObj KhoaHoc = new KhoaHocObj(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4),
                            res.getString(5),
                            res.getString(6),
                            res.getString(7)
                    );
                    listKhoaHoc.add(KhoaHoc);
                }
            } catch (SQLException e) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return listKhoaHoc;
    }

    public KhoaHocObj getKhoaHoc(String id){
        KhoaHocObj KhoaHoc = new KhoaHocObj();
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from KHOAHOC where MaKhoaHoc = ?";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                prst.setString(1, id);

                ResultSet res = prst.executeQuery();

                KhoaHoc.setId(res.getString(1));;
                KhoaHoc.setTenKhoaHoc(res.getString(2));
                KhoaHoc.setTenGiangVien(res.getString(3));
                KhoaHoc.setMoTaKhoaHoc(res.getString(4));
                KhoaHoc.setAnhKhoaHoc(res.getString(5));
                KhoaHoc.setThoiGianHoc(res.getString(6));
                KhoaHoc.setDoKho(res.getString(7));

            } catch (SQLException e) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return KhoaHoc;
    }

    public void addKhoaHoc(KhoaHocObj KhoaHoc) {
        String sqlCommand = "INSERT INTO KHOAHOC (MaKhoaHoc, TenKhoaHoc, TenGiangVien, MoTaKhoaHoc, AnhMoTa, ThoiGianHocDuKien, DoKho) values (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, KhoaHoc.getId());
            pstmt.setString(2, KhoaHoc.getTenKhoaHoc());
            pstmt.setString(3, KhoaHoc.getTenGiangVien());
            pstmt.setString(4, KhoaHoc.getMoTaKhoaHoc());
            pstmt.setString(5, KhoaHoc.getAnhKhoaHoc());
            pstmt.setString(6, KhoaHoc.getThoiGianHoc());
            pstmt.setString(7, KhoaHoc.getDoKho());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateKhoaHoc(KhoaHocObj KhoaHoc){
        String sqlCommand = "UPDATE KHOAHOC set TenKhoaHoc = ?, TenGiangVien = ?, MoTaKhoaHoc = ?, AnhMoTa = ?, ThoiGianHocDuKien = ?, DoKho = ? where MaKhoaHoc = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, KhoaHoc.getTenKhoaHoc());
            pstmt.setString(2, KhoaHoc.getTenGiangVien());
            pstmt.setString(3, KhoaHoc.getMoTaKhoaHoc());
            pstmt.setString(4, KhoaHoc.getAnhKhoaHoc());
            pstmt.setString(5, KhoaHoc.getThoiGianHoc());
            pstmt.setString(6, KhoaHoc.getDoKho());
            pstmt.setString(7, KhoaHoc.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteKhoaHoc(String id){
        String sqlCommand = "DELETE FROM KHOAHOC where MaKhoaHoc = ?";
        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {
            baiHocDAO.deleteAllBaiHocFromKhoaHoc(id);
            pstmt.setString(1, id);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
