import java.util.Scanner;

public class prog3{
    public static void main(String[] args){
        if(args.length == 0){
            System.out.print("PLease provide a number");
        }
        int n = Integer.parseInt(args[0]);
        int prev2 = 0,prev1 = 1,curr = 0;
        if(n <= 1) {
            System.out.print(n + " ");
        }
        System.out.print("Fibbonaci Series:" + " " + prev2 + " " + prev1 + " ");;
        for(int i = 2;i<=n;i++){
            curr = prev1 + prev2;
            System.out.print(curr + " ");
            prev2 = prev1;
            prev1 = curr;
        }
    }
}