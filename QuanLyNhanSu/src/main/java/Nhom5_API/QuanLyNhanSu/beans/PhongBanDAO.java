package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Nhom5_API.QuanLyNhanSu.model.PhongBanObj;
import jakarta.ejb.Stateless;

@Stateless
public class PhongBanDAO {
    public List<PhongBanObj> getListPhongBan(){
        List<PhongBanObj> listPhongBan = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from PHONGBAN";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while(res.next()){
                    PhongBanObj PhongBan = new PhongBanObj(
                            res.getString(1),
                            res.getString(2),
                            res.getString(3),
                            res.getString(4)
                            );
                    listPhongBan.add(PhongBan);

                }



            } catch (SQLException e) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listPhongBan;
    }
}
