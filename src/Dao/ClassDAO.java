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
    public void deleteClass(int ID) {
        String sql = "select classID, count(studentID) as sL from student where classID = ? group by classID";
        int row = 0;
        try(Connection conn = ConnectionSQL.ketNoi();
        PreparedStatement pr = conn.prepareStatement(sql)) {
            pr.setInt(1, ID);
            try(ResultSet rs = pr.executeQuery()) {
                while(rs.next()) {
                    row = rs.getInt("sL");
                }
            }
        }catch (SQLException e) {
            System.out.println("loi database");
            e.printStackTrace();
        }
        if(row == 0) {
            String sql2 = "delete from class where classID = ?";
            try(Connection conn = ConnectionSQL.ketNoi();
            PreparedStatement pr = conn.prepareStatement(sql2)) {
                pr.setInt(1, ID);
                int kiemTra = pr.executeUpdate();
                if(kiemTra > 0) {
                    System.out.println("Da xoa lop thanh cong");
                } else {
                    System.out.println("loi chua the xoa lop");
                }
            } catch(SQLException e) {
                System.out.println("Loi database");
                e.printStackTrace();
            }
        } else {
            System.out.println("khong the xoa lop do da co sinh vien hoc");
        }
    }

}
