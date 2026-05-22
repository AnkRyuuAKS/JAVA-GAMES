// Common base class
abstract class Entity {
    protected int id;

    public void setId(int id) { this.id = id; }
    public int getId() { return id; }
}

public void method(){
    
}

// Interface for DB operations
interface DBEntity {
    void insert(DBEntity entity);
    void delete(DBEntity entity);
    void update(DBEntity entity);
}

// Doctor entity
class Doctor extends Entity implements DBEntity {
    private String name;
    private String specialization;
    private int chamberFloor;

    // setters
    public void setName(String name) { this.name = name; }
    public void setSpecialization(String specialization) { this.specialization = specialization; }
    public void setChamberFloor(int chamberFloor) { this.chamberFloor = chamberFloor; }

    // DB operations - we are passing the objects but the parent that is type casted into one
    @Override
    public void insert(DBEntity entity) {
        Doctor d = (Doctor) entity;
        System.out.println("Inserting doctor with id: " + d.getId() + " into database");
    }

    @Override
    public void delete(DBEntity entity) {
        Doctor d = (Doctor) entity;
        System.out.println("Deleting doctor with id: " + d.getId() + " from database");
    }

    @Override
    public void update(DBEntity entity) {
        Doctor d = (Doctor) entity;
        System.out.println("Modifying information of doctor with id: " + d.getId() + " in database");
    }
}

// Patient entity
class Patient extends Entity implements DBEntity {
    private String name;
    private int age;
    private String disease;

    // setters
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
    public void setDisease(String disease) { this.disease = disease; }

    // DB operations
    @Override
    public void insert(DBEntity entity) {
        Patient p = (Patient) entity;
        System.out.println("Inserting patient with id: " + p.getId() + " into database");
    }

    @Override
    public void delete(DBEntity entity) {
        Patient p = (Patient) entity;
        System.out.println("Deleting patient with id: " + p.getId() + " from database");
    }

    @Override
    public void update(DBEntity entity) {
        Patient p = (Patient) entity;
        System.out.println("Modifying information of patient with id: " + p.getId() + " in database");
    }
}

// Main runner
public class Main {
    public static void main(String[] args) {
        Doctor doc = new Doctor();
        doc.setId(101);
        doc.setName("Dr. Smith");
        doc.setSpecialization("Cardiologist");
        doc.setChamberFloor(3);

        Patient pat = new Patient();
        pat.setId(201);
        pat.setName("John Doe");
        pat.setAge(45);
        pat.setDisease("Flu");

        // Perform DB operations
        doc.insert(doc);
        doc.update(doc);
        doc.delete(doc);

        System.out.println("------");

        pat.insert(pat);
        pat.update(pat);
        pat.delete(pat);
    }
}
