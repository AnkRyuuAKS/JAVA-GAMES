import java.util.Scanner;

public class prog5{
    public static void main(String[] args){
        String str = new String(args[0]);
        for(int i = 0;i<str.length()/2;i++){
            if(str.charAt(i) != str.charAt(str.length() - 1 - i)){
                System.out.println(str + "is not a palindrome");
                return;
            }
        }
        System.out.println(str + " is a palindrome");
    }
}