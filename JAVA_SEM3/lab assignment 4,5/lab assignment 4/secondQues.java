import java.util.*;

interface DBEntity{
    void insert(DBEntity obj);
    void delete(int x);
    void update(int x,DBEntity obj);
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

public class secondQues{
    public static void main(String a[]){
        Doctor doc = new Doctor();
        doc.setId("D101");
        doc.setName("Dr. Smith");
        doc.setSpecialization("Cardiology");
        doc.setChamberId("C1");

        Staff staff = new Staff();
        staff.setId("S201");
        staff.setName("John Doe");
        staff.setDepartment("Nursing");
        staff.setChamberId("C2");

        Patient patient = new Patient();
        patient.setId("P301");
        patient.setName("Jane Roe");
        patient.setDoctorAssigned("D101");
        patient.setChamberId("C3");

        DBEntity doc1 = new Doctor();
        DBEntity staff1 = new Staff();
        DBEntity patient1 = new Patient();
        
        doc1.insert(doc);
        doc1.delete(1);
        doc1.update(1, doc);

        staff1.insert(staff);
        staff1.delete(2);
        staff1.update(2, staff);

        patient1.insert(patient);
        patient1.delete(3);
        patient1.update(3, patient);
    }
}