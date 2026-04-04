package Dao;
import Model.Class;
import Model.Student;
import Util.ConnectionSQL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
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
    public ArrayList<Class> getAllClass() {
        ArrayList<Class> listClass = new ArrayList<>();
        String sql = "select * from class";
        try(Connection conn = ConnectionSQL.ketNoi();
            PreparedStatement pr = conn.prepareStatement(sql)) {
            try(ResultSet rs = pr.executeQuery()) {
               while(rs.next()) {
                   Class cl = new Class();
                   cl.setClassID(rs.getInt("classID"));
                   cl.setNameClass(rs.getString("nameClass"));
                   listClass.add(cl);
               }
            }
        } catch (SQLException e) {
            System.out.println("loi ket noi");
            e.printStackTrace();
        }
        return listClass;
    }

}
