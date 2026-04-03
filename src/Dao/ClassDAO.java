package Dao;
import Model.Class;
import Util.ConnectionSQL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
public class ClassDAO {
    public void insertClass(Class x) {
        String sql = "insert into class (nameClass) values (?)";
        try (Connection conn = ConnectionSQL.ketNoi();
        PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, x.getNameClass());
            int row = ps.executeUpdate();
            if(row > 0) {
                System.out.println("Da them lop ( " + x.getNameClass() + " ) thanh cong!!!");
            } else {
                System.out.println("them lop khong thanh cong");
            }
        } catch(SQLException e) {
            System.out.println("loi ket noi");
            e.printStackTrace();
        }
    }
}
