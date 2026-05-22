import java.util.*;

interface Iface1{
    void imf1();
    private void pvt1(){
        System.out.println("Private method in the classs");
    }
    default void df1(){
        System.out.println("Default method of interface - defined");
    };
}

class Concrete implements Iface1{
    public void imf1(){
        System.out.println("Implemented method of interface - undefined");
    }

}

public class firstQues{
    public static void main(String[] a){
        Concrete obj = new Concrete();
        obj.imf1();
        obj.df1();
    }
}