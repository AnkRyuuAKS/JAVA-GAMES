import java.util.*;
public class Patterns{
    public static void printHallowRec(int totRows ,int totCols){
        for(int i = 0;i<=totRows;i++){
            for(int j = 0;j<=totCols;j++){
                if(i == 0||i==totRows||j==0||j==totCols){
                    System.out.print("**");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
    //Inverted or rotated half cycle:-
    public static void inverted(int n){
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<= n-i;j++){
                System.out.print(" ");
            }
            for(int j = 1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    //Butterfly Pattern;=
    public static void butterfly(int n){
        for(int i=1;i<n;i++){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
        for(int i=n;i>1;i--){
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String args[]){
        printHallowRec(4,5);
        inverted(4);
        butterfly(5);

    }
}