import java.util.*;

interface DBEntity{
    void insert(DBEntity obj);
    void delete(int x);
    void update(int x,DBEntity obj);
}

class Doctor implements DBEntity{
    public void insert(DBEntity obj){
        System.out.println("from insert method of Doctor class");
    }
    public void delete(int x){
        System.out.println("from delete method of Doctor class");
    }
    public void update(int x,DBEntity obj){
        System.out.println("from update method of Doctor class");
    }
}

class Staff implements DBEntity {
    public void insert(DBEntity obj) {
        System.out.println("from insert method of Staff class");
    }
    public void delete(int x) {
        System.out.println("from delete method of Staff class");
    }
    public void update(int x, DBEntity obj) {
        System.out.println("from update method of Staff class");
    }
}

class Patient implements DBEntity {
    public void insert(DBEntity obj) {
        System.out.println("from insert method of Patient class");
    }
    public void delete(int x) {
        System.out.println("from delete method of Patient class");
    }
    public void update(int x, DBEntity obj) {
        System.out.println("from update method of Patient class");
    }
}

public class firstQues{
    public static void main(String a[]){
        DBEntity doc = new Doctor();
        DBEntity staff = new Staff();
        DBEntity patient = new Patient();

        doc.insert(doc);
        doc.delete(1);
        doc.update(1, doc);

        staff.insert(staff);
        staff.delete(2);
        staff.update(2, staff);

        patient.insert(patient);
        patient.delete(3);
        patient.update(3, patient);
    }
}