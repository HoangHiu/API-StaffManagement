package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


import Nhom5_API.QuanLyNhanSu.model.ChucVuObj;
import jakarta.ejb.Stateless;

@Stateless
public class ChucVuDAO {

    public List<ChucVuObj> getListChucVu(){
        List<ChucVuObj> listChucVu = new ArrayList<>();

        try {
            Class.forName("org.sqlite.JDBC");
            try(Connection conn = connectDB.getConnection();

            ) {
                String sqlQuery = "Select * from CHUCVU";
                PreparedStatement prst = conn.prepareStatement(sqlQuery);
                ResultSet res = prst.executeQuery();

                while(res.next()){
                    ChucVuObj ChucVu = new ChucVuObj(
                            res.getString(1),
                            res.getString(2)
                    );
                    listChucVu.add(ChucVu);

                }
            } catch (SQLException e) {

            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return listChucVu;
    }
}
