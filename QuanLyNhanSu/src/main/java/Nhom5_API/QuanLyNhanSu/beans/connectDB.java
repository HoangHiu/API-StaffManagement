package Nhom5_API.QuanLyNhanSu.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:D:\\workspace\\Java\\QuanLyNhanSu\\src\\main\\java\\Nhom5_API\\QuanLyNhanSu\\database\\N5_QLNhanSu.db");
            System.out.println("Connection initialized: " + conn);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error initializing connection: " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }
}
