class Employee{
    private String name,id,office,designation;

    public Employee(String name,String id,String office,String designation){
        this.name = name;
        this.id = id;
        this.office = office;
        this.designation = designation;
    }
}

class Developer extends Employee {
    public Developer(String name, String id, String office) {
        super(name, id, office, "developer");//used to override the constructor
    }
}

class Manager extends Employee {
    public Manager(String name, String id, String office) {
        super(name, id, office, "manager");
    }

}

public class thirdProb{
    public static void main(String[] args){
        Developer d1 = new Developer("Ankit","101","google");
        Manager m1 = new Manager("Sahiti","102","google");
    }
}