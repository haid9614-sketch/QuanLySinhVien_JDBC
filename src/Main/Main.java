package Main;
import Util.*;
import Model.Class;
import Model.Student;
import Dao.ClassDAO;
import Dao.StudentDAO;
import java.sql.Connection;
import java.sql.SQLException;
public class Main {
   public static void main(String[] args) {
      Student st2 = new Student("long", "long556@gmail.com", 1);
      StudentDAO dao1 = new StudentDAO();
      dao1.deleteStudent(8);



//      Class lop1 = new Class("CNTT");
//      ClassDAO Dao1 = new ClassDAO();
//      Dao1.insertClass(lop1);
   }
}
