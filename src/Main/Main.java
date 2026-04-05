package Main;
import Util.*;
import java.util.Scanner;
import Control.QuanLySinhVien;
public class Main {
   public static void main(String[] args) {
      QuanLySinhVien ql = new QuanLySinhVien();
      Scanner sc = new Scanner(System.in);
      while(true) {
       System.out.println("------------------------Quan ly sinh vien---------------------------------");
      System.out.println("1. hien thi danh sach toan bo sinh vien");
      System.out.println("2. hien thi toan bo danh sach lop");
      System.out.println("3. them lop hoc");
      System.out.println("4. them sinh vien");
      System.out.println("5. xoa sinh vien");
      System.out.println("6. xoa lop hoc");
      System.out.println("7. tim kiem sinh vien");
      System.out.println("0. thoat chuong trinh");
      System.out.println("------------------------------------------------------------------------------");
      System.out.print("Nhap lua chon cua ban: ");
      int choice = Integer.parseInt(sc.nextLine());
      switch(choice) {
         case 1:
            ql.hienThiAllControl();
            break;
         case 2:
            ql.hienThiAllClassControl();
            break;
         case 3:
            ql.themClassControl();
            break;
         case 4:
            ql.themStudentControl();
            break;
         case 5:
            ql.xoaStudentControl();
            break;
         case 6:
            ql.xoaClassControl();
            break;
         case 7:
            ql.searchStudentControl();
            break;
         case 0:
            System.exit(0);
         default:
            System.out.println("lua chon khong phu hop");
      }
      }
//      StudentDAO dao1  = new StudentDAO();
//      ClassDAO dao2 = new ClassDAO();
//      dao2.deleteClass(1);
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
