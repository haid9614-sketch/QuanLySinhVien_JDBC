package Control;
import Dao.ClassDAO;
import Dao.StudentDAO;
import Model.Student;
import Model.Class;
import java.util.ArrayList;
import java.util.Scanner;
public class QuanLySinhVien {
    Scanner sc = new Scanner(System.in);
 public void hienThiAllControl() {
     System.out.println("------------------TOAN BO DANH SACH SINH VIEN----------------------------");
     StudentDAO dao = new StudentDAO();
     ArrayList<Student> list = dao.getAllStudent();
     for(Student x : list) {
         System.out.println(x + " | Lop: " + x.getNameClass());
     }
  }
  public void themStudentControl () {
     System.out.println("--------------NHAP THONG TIN SINH VIEN------------------------");
     System.out.print("nhap ten sinh vien: ");
     String name = sc.nextLine();
     System.out.println("nhap email cua sinh vien");
     String email = sc.nextLine();
     int classID = 0;
      while(true) {
          System.out.print("nhap ID lop cua sinh vien");
          String input = sc.nextLine();
          try{
              classID = Integer.parseInt(input);
              break;
          }catch(NumberFormatException e) {
              System.out.println(" ID sinh vien phai la so, vui long nhap lai");
          }
      }
      Student st1 = new Student(name, email, classID);
      StudentDAO dao = new StudentDAO();
      dao.insertStudent(st1);
  }
    public void themClassControl () {
        System.out.println("--------------NHAP THONG TIN LOP------------------------");
        System.out.print("nhap ten Lop: ");
        String name = sc.nextLine();
        Class cl = new Class(name);
        ClassDAO dao = new ClassDAO();
        dao.insertClass(cl);
    }
}
