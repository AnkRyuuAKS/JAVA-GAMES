public class Oops{
    public static void main (String args[]){
        Pen p1 = new Pen();//a pen object called p1
        p1.changeColor("blue");
        System.out.println(p1.getColor());
        p1.setTip(5);
        System.out.println(p1.getTip());
        p1.setTip(4);
        System.out.println(p1.getTip());
      
    //checking constructor :-
    
        // Student s1 = new Student();
        // Student s2 = new Student("ankit");
        // Student s3 = new Student("Ravi",1234);

    Student s1 = new Student();
    s1.name = "Ankit";
    s1.roll = 456;
    s1.password ="abcs";
    s1.marks[0] = 100;
    s1.marks[1] = 93;
    s1.marks[2] = 93;

    Student s2 = new Student(s1);//copy
    s2.password = "xyz";
    s1.marks[1] = 94;

    for(int i=0 ;i<3;i++){
        System.out.println(s2.marks[i]);
    }

   //CHECKING FOR INHERITANCE:-
     fish Shark = new fish();
     Shark.eat();
     tuna t1 = new tuna();
     tuna.eats();
     tuna.fin = 4;
     System.out.println(tuna.fin);
    } 
}

//Base class:-
class Animal{
    String color;
    void eat(){
        System.out.println("eats");
    }
    void breathe(){
        System.out.println("breathes");
    } 
}
//Derived class :-
class Fish extends Animal{
    int fin;

    void Swim(){
        System.out.println("Swims"); 
    }
}
//Derived of derived class:-
class tuna extends Fish {
    int weight;
}
//hierarchaial inheritance:-
class mammals extends Animal{
    void walks(){
        System.out.println("walks");
    }
}

class Student{
    String name;
    int roll;
    String password;
    int marks[];
 
 //shallow copy constructor:-
    // Student(Student s1){
        // this.name = s1.name;
        // this.roll = s1.roll;
        // marks = new int[3];
        // this.marks = s1.marks;
    // }
  //deep copy constuctor:-
  //the value will be unchanged even if it is altered in one object
  Student(Student s1){
        this.name = s1.name;
        this.roll = s1.roll;
        marks = new int[3];
        for(int i = 0;i<marks.length;i++){
            this.marks[i] = s1.marks[i];
        }
  }


    Student(){//Non -Parametrized constructor
        System.out.println("constructer is called.....");
        marks = new int[3];
    }
    Student(String name){//Parametrized constuctor
        this.name = name; 
        marks = new int[3];
    }
    Student(int roll){
        this.roll = roll;
        marks = new int[3];
    }
    Student(String name , int roll){
        this.name = name;
        this.roll = roll;
        marks = new int[3];
        
    }
}
//Always write this below public class
class Pen{
    private String color;
    private int tip;

    String getColor(){
        return this.color;
        //'this' returns the original vlaue
    }
    int getTip(){
        return this.tip;
    }

    void changeColor(String newColor){
        color = newColor;
    }
    void setTip(int newTip){
        tip = newTip;
    }
}