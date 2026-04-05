package Main;
import Util.*;
import Model.Class;
import Model.Student;
import Dao.ClassDAO;
import Dao.StudentDAO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
public class Main {
   public static void main(String[] args) {
      StudentDAO dao1  = new StudentDAO();
      ClassDAO dao2 = new ClassDAO();
      dao2.deleteClass(1);

//      ArrayList<Student> listSearch = dao1.searchStudent("duong");
//      for(Student x : listSearch) {
//         System.out.println(x + " | lop: " + x.getNameClass());
//      }
//      Student st2 = new Student("long", "long556@gmail.com", 1);
//      StudentDAO dao1 = new StudentDAO();
//      dao1.deleteStudent(8);
//      Class lop1 = new Class("CNTT");
//      ClassDAO Dao1 = new ClassDAO();
//      Dao1.insertClass(lop1);
   }
}
