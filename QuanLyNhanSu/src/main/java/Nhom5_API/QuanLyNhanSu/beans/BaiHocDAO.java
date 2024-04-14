package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.BaiHocObj;
import jakarta.ejb.Stateless;

@Stateless
public class BaiHocDAO {

    public List<BaiHocObj> searchListBaiHoc(String name){
        List<BaiHocObj> listBaiHoc = new ArrayList<BaiHocObj>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from BAIHOC where TenBaiHoc LIKE '%" + name + "%' ";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet rs = prst.executeQuery();

                while(rs.next()){
                    BaiHocObj BaiHoc = new BaiHocObj();

                    BaiHoc.setId(rs.getString(1));
                    BaiHoc.setTenBaiHoc(rs.getString(2));
                    BaiHoc.setNoiDung(rs.getString(3));
                    BaiHoc.setMoTa(rs.getString(4));
                    BaiHoc.setMaKhoaHoc(rs.getString(5));
                    
                    listBaiHoc.add(BaiHoc);

                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listBaiHoc;
    }

    public int checkID(BaiHocObj BaiHoc){
        if (BaiHoc.getId() == null || BaiHoc.getTenBaiHoc().isEmpty()) {
            System.out.println("Info cannot be empty.");
            return 0;
        }
        String sql = "SELECT * FROM BAIHOC WHERE MaBaiHoc = ?";

        try (Connection conn = connectDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, BaiHoc.getId());

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return 0;
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return 1;
    }

    public List<BaiHocObj> getListBaiHocFromIdKhoaHoc(String id){
        List<BaiHocObj> listBaiHoc = new ArrayList<>();
        String sqlComm = "Select * FROM BAIHOC WHERE MaKhoaHoc = ?";


        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlComm)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                BaiHocObj BaiHoc = new BaiHocObj();

                BaiHoc.setId(rs.getString(1));
                BaiHoc.setTenBaiHoc(rs.getString(2));
                BaiHoc.setNoiDung(rs.getString(3));
                BaiHoc.setMoTa(rs.getString(4));
                BaiHoc.setMaKhoaHoc(rs.getString(5));

                listBaiHoc.add(BaiHoc);
            }

            return listBaiHoc;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return listBaiHoc;
    }

    public BaiHocObj getBaiHoc(String id){
        BaiHocObj BaiHoc = new BaiHocObj();
        try {
            Class.forName("org.sqlite.JDBC");
            try (Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from BaiHoc where MaBaiHoc = ?";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                prst.setString(1, id);

                ResultSet res = prst.executeQuery();

                BaiHoc.setId(res.getString(1));;
                BaiHoc.setTenBaiHoc(res.getString(2));
                BaiHoc.setNoiDung(res.getString(3));
                BaiHoc.setMoTa(res.getString(4));
                BaiHoc.setMaKhoaHoc(res.getString(5));

            } catch (SQLException e) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return BaiHoc;
    }

    public void addBaiHoc(BaiHocObj BaiHoc) {
        String sqlCommand = "INSERT INTO BAIHOC (MaBaiHoc, TenBaiHoc, NoiDungBaiHoc, MoTaBaiHoc, MaKhoaHoc) values (?, ?, ?, ?, ?)";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, BaiHoc.getId());
            pstmt.setString(2, BaiHoc.getTenBaiHoc());
            pstmt.setString(3, BaiHoc.getNoiDung());
            pstmt.setString(4, BaiHoc.getMoTa());
            pstmt.setString(5, BaiHoc.getMaKhoaHoc());
            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateBaiHoc(BaiHocObj BaiHoc){
        String sqlCommand = "UPDATE BAIHOC set TenBaiHoc = ?, NoiDungBaiHoc = ?, MoTaBaiHoc = ? where MaBaiHoc = ?";

        try (Connection conn = connectDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sqlCommand)) {

            pstmt.setString(1, BaiHoc.getTenBaiHoc());
            pstmt.setString(2, BaiHoc.getNoiDung());
            pstmt.setString(3, BaiHoc.getMoTa());
            pstmt.setString(4, BaiHoc.getId());

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteBaiHoc(String id){
        String sqlCommand = "DELETE FROM BAIHOC where MaBaiHoc = ?";

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

    public void deleteAllBaiHocFromKhoaHoc(String id){
        String sqlCommand = "DELETE FROM BAIHOC where MaKhoaHoc = ?";

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
