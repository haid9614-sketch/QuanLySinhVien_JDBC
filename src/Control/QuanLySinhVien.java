package Control;
import Dao.ClassDAO;
import Dao.StudentDAO;
import Model.Student;
import Model.Class;
import java.util.ArrayList;
import java.util.Scanner;
public class QuanLySinhVien {
    Scanner sc = new Scanner(System.in);
    StudentDAO daoSt = new StudentDAO();
    ClassDAO daoCl = new ClassDAO();
 public void hienThiAllControl() {
     System.out.println("------------------TOAN BO DANH SACH SINH VIEN----------------------------");
     ArrayList<Student> list = daoSt.getAllStudent();
     for(Student x : list) {
         System.out.println(x + " | Lop: " + x.getNameClass());
     }
  }
  public void hienThiAllClassControl() {
     System.out.println("-------------------TOAN BO DANH SACH LOP LA---------------------------------");
     ArrayList<Class> list = daoCl.getAllClass();
     for(Class x : list) {
         System.out.println(x);
     }
  }
  public void themStudentControl () {
     System.out.println("--------------NHAP THONG TIN SINH VIEN------------------------");
     System.out.print("nhap ten sinh vien: ");
     String name = sc.nextLine();
     System.out.print("nhap email cua sinh vien: ");
     String email = sc.nextLine();
     int classID = 0;
      while(true) {
          System.out.print("nhap ID lop cua sinh vien: ");
          String input = sc.nextLine();
          try{
              classID = Integer.parseInt(input);
              break;
          }catch(NumberFormatException e) {
              System.out.println(" ID sinh vien phai la so, vui long nhap lai");
          }
      }
      Student st1 = new Student(name, email, classID);
      daoSt.insertStudent(st1);
  }
    public void themClassControl () {
        System.out.println("--------------NHAP THONG TIN LOP------------------------");
        System.out.print("nhap ten Lop: ");
        String name = sc.nextLine();
        Class cl = new Class(name);
        daoCl.insertClass(cl);
    }
    public void xoaStudentControl() {
         int ID = 0;
         while(true) {
             System.out.print("nhap ID sinh vien muon xoa: ");
             String input = sc.nextLine();
             try {
                 ID = Integer.parseInt(input);
                 break;
             } catch(NumberFormatException e) {
                 System.out.println(" ID sinh vien phai la so, vui long nhap lai");
             }
         }
         daoSt.deleteStudent(ID);
    }
    public void xoaClassControl() {
     int ID = 0;
     while(true) {
         System.out.print("nhap ID lop hoc muon xoa: ");
         String input = sc.nextLine();
         try{
             ID = Integer.parseInt(input);
             break;
         } catch (NumberFormatException e) {
             System.out.println("ID lop phai la so, vui long nhap lai ");
         }
     }
     daoCl.deleteClass(ID);
    }
    public void searchStudentControl() {
     System.out.print("nhap ten sinh vien muon tim kiem: ");
     String name = sc.nextLine();
     ArrayList<Student> list = daoSt.searchStudent(name);
     System.out.println("danh sach sinh vien duoc tim thay la");
     for(Student x : list) {
         System.out.println(x + " | lop: " + x.getNameClass());
     }
    }
}
