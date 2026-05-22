import java.util.*;

interface DBEntity{
    //interface only takes - default ,static ,private methods only
    void insert(DBEntity obj);
    void delete(int x);
    void update(int x,DBEntity obj);

    default void alter(){
        System.out.println("Implementation in progress");
    }

    //static factory method
    static DBEntity createEntity(String type){
        String t = type.toLowerCase();
        switch(t){
            case "doctor":
                return new Doctor();
            case "staff":
                return new Staff();
            case "patient":
                return new Patient();
            default:
                return null;
        }
    }
}

class Doctor implements DBEntity{
    String id, name, specialization, chamber_id;

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }
    public void setChamberId(String chamber_id){
        this.chamber_id = chamber_id;
    }
    public void insert(DBEntity obj){
        Doctor d = (Doctor)obj;
        System.out.println("Inserting doctor with id: " + d.id );
    }
    public void delete(int x){
        System.out.println("Deleting doctor with id: " + this.id );
    }
    public void update(int x,DBEntity obj){
        Doctor d = (Doctor)obj;
        System.out.println("Modifying information of doctor with id: " + d.id);
    }
}

class Staff implements DBEntity {
    String id, name, department, chamber_id;

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public void setChamberId(String chamber_id){
        this.chamber_id = chamber_id;
    }

    public void insert(DBEntity obj) {
        Staff s = (Staff)obj;
        System.out.println("Inserting staff with id: " + s.id );
    }
    public void delete(int x) {
        System.out.println("Deleting staff with id: " + this.id );
    }
    public void update(int x, DBEntity obj) {
        Staff s = (Staff)obj;
        System.out.println("Modifying information of staff with id: " + s.id);
    }
}

class Patient implements DBEntity {
    String id, name, doctorAssigned, chamber_id;

    public void setId(String id){
        this.id = id;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setDoctorAssigned(String doctorAssigned){
        this.doctorAssigned = doctorAssigned;
    }
    public void setChamberId(String chamber_id){
        this.chamber_id = chamber_id;
    }

    public void insert(DBEntity obj) {
        Patient p = (Patient)obj;
        System.out.println("Inserting patient with id: " + p.id );
    }
    public void delete(int x) {
        System.out.println("Deleting patient with id: " + this.id );
    }
    public void update(int x, DBEntity obj) {
        Patient p = (Patient)obj;
        System.out.println("Modifying information of patient with id: " + p.id);
    }
}

public class fourthQues{
    public static void main(String a[]){
        DBEntity doc = DBEntity.createEntity("doctor");
        Doctor d = (Doctor)doc;
        d.alter();
        d.setId("D01");
        d.setName("Ankit");
        d.setSpecialization("orthology");
        d.setChamberId("C01");
        d.insert(d);
    }
}