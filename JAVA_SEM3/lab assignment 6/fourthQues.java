class InvalidEntryException extends Exception {
    private String details;

    public InvalidEntryException(String details) {
        super(details);
        this.details = details;
    }

    @Override
    public String getMessage() {
        return details;
    }

    @Override
    public String toString() {
        return "InvalidEntryException: " + details;
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) throws InvalidEntryException {
        if (age < 0) {
            throw new InvalidEntryException("Age cannot be negative: " + age);
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

public class fourthQues{
    public static void main(String[] args) {
        try {
            Person p1 = new Person("Alice", 25);
            System.out.println("Person created: " + p1.getName() + ", Age: " + p1.getAge());

            Person p2 = new Person("Bob", -5);
            System.out.println("Person created: " + p2.getName() + ", Age: " + p2.getAge());

        } catch (InvalidEntryException e) {
            System.out.println(e.getMessage());
            System.out.println(e);
        }

        System.out.println("Program continues after exception handling.");
    }
}
