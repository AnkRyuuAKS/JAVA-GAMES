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

class Concrete implements Iface1{
    public void imf1(){
        System.out.println("Implemented method of interface - undefined");
    }

}

class Concrete2 implements Iface1{
    public void imf1(){
        System.out.println("Implemented method of interface - undefined");
    }
    public void df1(){
        System.out.println("Default method of interface - redefined");
    }
}

public class secondQues{
    public static void main(String[] a){
        Iface1 obj = Iface1.factoryMethod("concrete1");
        obj.imf1();
        obj.df1();
        System.out.println("--------------");
        Iface1 obj2 = Iface1.factoryMethod("concrete2");
        obj2.imf1();
        obj2.df1();
    }
}