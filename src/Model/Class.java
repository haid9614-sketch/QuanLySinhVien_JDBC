package Model;
public class Class {
    private int classID;
    private String nameClass;
    public Class() {}
    public Class(int classID, String nameClass) {
        this.classID = classID;
        this.nameClass = nameClass;
    }
    public Class(String nameClass) {
        this.nameClass = nameClass;
    }
    public int getClassID() {
        return this.classID;
    }
    public void setClassID(int classID) {
        this.classID = classID;
    }
    public String getNameClass() {
        return this.nameClass;
    }
    public void setNameClass(String nameClass) {
        this.nameClass = nameClass;
    }
   @Override
    public String toString() {
        return "Ten Lop hoc: " + this.nameClass + " | ma lop: " + this.classID;
   }
}
