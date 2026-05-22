import java.util.Scanner;

public class prog9{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.print("Please provide a number");
            return;
        }
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);

        System.out.println("Enter your operation from (*, /. %, +, -).");
        Scanner scanner = new Scanner(System.in);
        String op = scanner.next();
        double result = 0;
        switch(op){
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "%":
                result = a % b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;

            default:
                System.out.println("Eneter valid operation.");
                return;
        }
        System.out.println("Result of " + a + " " + op + " " + b + " = " + result);
        scanner.close();
    }
}