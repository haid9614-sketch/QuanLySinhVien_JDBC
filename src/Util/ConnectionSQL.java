package Util;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class ConnectionSQL {
    public static Connection ketNoi() {
        String url = "jdbc:mysql://localhost:3306/QuanLy_SinhVien_JDBC";
        String user = "root";
        String password = "23102006";

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("kết nối với Database thành công!");
        } catch (SQLException e) {
            System.out.println("Lỗi kết nối rồi!");
            e.printStackTrace();
        }

        return connection;
    }
}
