package Dao;
import Util.ConnectionSQL;
import Model.Class;
import Model.Student;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class StudentDAO {
    public void insertStudent(Student x) {
        ClassDAO classDAO1 = new ClassDAO();
         ArrayList<Class> listClass = classDAO1.getAllClass();
         boolean find = false;
         for(Class a : listClass) {
             if(a.getClassID() == x.getClassID()) {
                 find = true;
             }
         }
         if(find == false) {
             System.out.println("Loi Khong The Them SinhVien Vao Lop Khong Ton Tai!!!");
         } else {
             String sql = "insert into student (name, email, classID) value (?, ?, ?)";
             try( Connection conn = ConnectionSQL.ketNoi();
                  PreparedStatement pr = conn.prepareStatement(sql)) {
                  pr.setString(1, x.getName());
                  pr.setString(2, x.getEmail());
                  pr.setInt(3, x.getClassID());
                  int row = pr.executeUpdate();
                  if(row > 0) {
                      System.out.println("da them sinh vien ( " + x.getName() + " ) thang cong !!");
                  } else {
                      System.out.println("them sinh vien that bai");
                  }
             } catch (SQLException e) {
                  System.out.println("loi database");
                  e.printStackTrace();
             }
         }
    }
    public ArrayList<Student> getAllStudent() {
        String sql = "select * from student s inner join class c on s.classID = c.classID";
        ArrayList<Student> listStudent = new ArrayList<>();
        try( Connection conn = ConnectionSQL.ketNoi();
              PreparedStatement pr = conn.prepareStatement(sql)) {
            try(ResultSet rs = pr.executeQuery()) {
                while(rs.next()) {
                    Student st = new Student();
                    st.setStudentID(rs.getInt("studentID"));
                    st.setName(rs.getString("name"));
                    st.setEmail(rs.getString("email"));
                    st.setClassID(rs.getInt("classID"));
                    st.setNameClass(rs.getString("nameClass"));
                    listStudent.add(st);
                }
            }

        } catch (SQLException e) {
            System.out.println("loi database");
            e.printStackTrace();
        }
        return listStudent;
    }
    public void deleteStudent(int ID) {
        String sql = "delete from student where studentID = ?";
        try (Connection conn = ConnectionSQL.ketNoi();
             PreparedStatement pr = conn.prepareStatement(sql)) {
            pr.setInt(1, ID);
            int row = pr.executeUpdate();
            if (row > 0) {
                System.out.println("DA XOA SINH VIEN THANH CONG");
            } else {
                System.out.println("Loi: Sinh vien khong ton tai!");
            }
        } catch (SQLException e) {
            System.out.println("loi database");
            e.printStackTrace();
        }
    }
    public ArrayList<Student> searchStudent(String name) {
        ArrayList<Student> list = new ArrayList<>();
        String sql = "select * from student s inner join class c on s.classID = c.classID where lower(name) like ?";
        try( Connection conn = ConnectionSQL.ketNoi();
                PreparedStatement pr = conn.prepareStatement(sql)
                ) { pr.setString(1, "%" + name.toLowerCase() + "%");
            try(ResultSet rs = pr.executeQuery()) {
                while(rs.next()) {
                    Student st = new Student();
                    st.setStudentID(rs.getInt("studentID"));
                    st.setName(rs.getString("name"));
                    st.setEmail(rs.getString("email"));
                    st.setClassID(rs.getInt("classID"));
                    st.setNameClass(rs.getString("nameClass"));
                    list.add(st);
                }

            }
        }catch (SQLException e) {
            System.out.println("loi da database");
            e.printStackTrace();
        }
        return list;
    }
}
