 class Employee {
    private static int count = 0;

    public Employee() {
        count++;
    }

    public static int getEmployeeCount() {
        return count;
    }
}

public class fifthProb{
    public static void main(String[] args){
        Employee e1 = new Employee();
        Employee e2 = new Employee();
        Employee e3 = new Employee();
        Employee e4 = new Employee();

        System.out.println("Count = " + Employee.getEmployeeCount());
    }
}