import java.util.Scanner;

public class prog10{
    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);

        double disc = b * b - 4* a * c;
        if(disc >= 0){
            double root1 = (-b + Math.sqrt(disc)) / (2 * a);//(-b + math.sqrt(disc))/2
            double root2 = (-b - Math.sqrt(disc)) / (2 * a);
            if(root1 == root2){
                System.out.println("The roots are real and equal: " + root1);
            }else{
                System.out.println("The roots are real and distinct: " + root1 + " and " + root2);
            }
        }  
        else{
            System.out.println("The roots are complex.");
            double real = -b/(2*a);
            double imaginary = Math.sqrt(-disc)/(2*a);
            System.out.println("The imaginary roots are: " + real + "+" + imaginary + "i " +
                               real + "-" + imaginary + "i");
        }      
    }
}