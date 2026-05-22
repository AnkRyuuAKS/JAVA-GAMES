

abstract class Employee{
    private String name,id,office,designation;

    public Employee(String name,String id,String office,String designation){
        this.name = name;
        this.id = id;
        this.office = office;
        this.designation = designation;
    }

    public abstract void insert();//abstract classes = cannnot be called from the parent must be used in child class only
    public abstract void delete();

    public static Employee getEmployee(String type,String name, String id, String office){
        if(type.equals("developer")){
            return new Developer( name,  id,  office);
        }else if(type.equals("manager")){
            return new Manager( name,  id,  office);
        }else{
            return null;
        }
    }
}

class Developer extends Employee {
    public Developer(String name, String id, String office) {
        super(name, id, office, "developer");//used to override the constructor
    }
     @Override
    public void insert() {
        System.out.println("Data inserted in Developer database");
    }
    @Override
    public void delete() {
        System.out.println("Data deleted from Developer database");
    }
}

class Manager extends Employee {
    public Manager(String name, String id, String office) {
        super(name, id, office, "manager");
    }
     @Override
    public void insert() {
        System.out.println("Data inserted in Manager database");
    }
    @Override
    public void delete() {
        System.out.println("Data deleted from Manager database");
    }

}

public class fourthProb{
    public static void main(String[] args){
        Employee emp1 = Employee.getEmployee("developer", "Ankit", "101", "IT");
        Employee emp2 = Employee.getEmployee("manager", "Samita", "201", "HR");

        emp1.insert();
        emp2.insert();
    }
}