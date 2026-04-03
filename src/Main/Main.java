package Main;
import Util.*;
import Model.Class;
import Dao.ClassDAO;
import java.sql.Connection;
import java.sql.SQLException;
public class Main {
   public static void main(String[] args) {
      Class lop1 = new Class("CNTT");
      ClassDAO Dao1 = new ClassDAO();
      Dao1.insertClass(lop1);
   }
}
