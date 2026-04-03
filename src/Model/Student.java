package Model;
public class Student {
    private int studentID;
    private String name;
    private String email;
    private int classID;
    private String nameClass;
    public Student() {}
    public Student(String name, String email, int classID) {
        this.name = name;
        this.email = email;
        this.classID = classID;
    }
    public Student(int studentID, String name, String email, int classID) {
        this.studentID = studentID;
        this.name = name;
        this.email = email;
        this.classID = classID;
    }
    public int getStudentID() {
        return studentID;
    }
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public int getClassID() {
        return classID;
    }
    public void setClassID(int classID) {
        this.classID = classID;
    }
    public String getNameClass() {
        return nameClass;
    }
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
    @Override
    public String toString() {
        return "Mã SV: " + this.studentID + " | Tên: " + this.name + " | Email: " + this.email;
    }
}
