import java.util.*;

interface Iface1{
    void imf1();
    private void pvt1(){
        System.out.println("Private method in the classs");
    }
    default void df1(){
        System.out.println("Default method of interface - defined");
    };

    static Iface1 factoryMethod(String type){
        if(type.equals("concrete1")){
            return new Concrete();
        }else{
            return new Concrete2();
        }
    }
}

interface Iface2{
    void imf1();
    void imf2();
    default void df1(){
        System.out.println("Default class in the second interface");
    }
}

// First error == > the default method df1 is inherited from both the interfaces ,so jkl confuses which one to call
//Solutionn ===> use super keywoed to specify which one to call
//Second error  ==> the fuction imf1 is not declared in the classs
//Solution ==> define the method in the class
// Third error ==> You cannot call both Iface1.super.df1() and Iface2.super.df1() in the same method; 
//                 Java does not allow calling multiple interface default methods like this in a single method.
// Solution ==> You should call only one interface's default method using super, or provide your own implementation.
class Concrete implements Iface1,Iface2{
    public void imf1(){
        System.out.println("Implemented method of interface - undefined");
    }
    public void imf2(){
        System.out.println("Implemented method of interface2 - undefined");
    }
    public void df1(){
        Iface1.super.df1();
    }

}

class Concrete2 implements Iface1,Iface2{
    public void imf1(){
        System.out.println("Implemented method of interface - undefined");
    }
    public void imf2(){
        System.out.println("Implemented method of interface - undefined");
    }
    public void df1(){
        Iface2.super.df1();
        System.out.println("Default method of interface - redefined");
    }
}

public class thirdQues{
    public static void main(String[] a){
        Concrete obj = new Concrete();
        obj.imf2();
        obj.df1();

        Concrete2 obj2 = new Concrete2();
        obj2.imf2();
        obj2.df1();
    }
}