import java.util.Scanner;

public class prog1{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number:");
        int n = sc.nextInt();
        boolean isPrime = true;
        if(n<=1){
            isPrime = false;
        }
        for(int i = 2;i<=Math.sqrt(n);i++){
            if(n % i == 0) isPrime = false;
        }
        if(isPrime) System.out.print(n + " is a prime number.");
        else System.out.print(n + " is not a prime number.");
        sc.close();
    }
}