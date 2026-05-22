import java.util.*;

public class Strings{
    //To print the individual letters of the string:-
    public static void printLetters(String str){
        for(int i =0;i<str.length();i++){
            System.out.print(str.charAt(i) + " ");
        }
         System.out.println();
    }
    //Check the palindrome of the String
    public static boolean isPalindrome(String str1){
        for(int i =0;i<str1.length()/2;i++){
            if(str1.charAt(i) != str1.charAt(str1.length()-1-i)){
                //not a palindrome
                return false;
            }
        }
        return true;
    }

    //Shortest Path (s,w,n,e):-
    public static void shortPath(String path){
        int x = 0; int y = 0;
        for(int i = 0; i<path.length();i++){
        char dir = path.charAt(i);
        //South
        if( dir == 'S'){
            y--;
        }
        //North
        else if( dir == 'N'){
            y++;
        }
        //West
        else if( dir == 'W'){
            x--;
        }
        //East
        else {
            x++;
        }
        }
        int x2 = x*x;
        int y2 = y*y;
        int shortDist = (int)Math.sqrt(x2 + y2);
        System.out.println("the shortest distance from origin is"+ shortDist);
    }

    //Sunbstrings of strings :-
    public static String substring(String str2 , int si , int ei){
        String substr = "";
        for (int i = si;i<ei;i++){
            substr += str2.charAt(i);
        }
        return substr;
    }

    //To print the largest String:-
    public static void printLargest(String fruits[]){
        String largest = fruits[0];
        for(int i = 0;i<fruits.length;i++){
            if(largest.compareTo(fruits[i]) < 0){
                largest = fruits[i];
            }
        }
    System.out.println(largest);
    }//time complexity = 0(n); 

//To convert first letters of words to uppercase:-
    public static String toUpperCase(String str){
        StringBuilder sb = new StringBuilder("");

        char ch = Character.toUpperCase(str.charAt(0));
        sb.append(ch);

        for(int i = 1;i<str.length();i++){
            if(str.charAt(i) == ' ' && i<str.length() -1){
                sb.append(str.charAt(i));
                i++;
                sb.append(Character.toUpperCase(str.charAt(i)));
            } 
            else{
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
        //used to convert stringBuilder to string
    }
    //String compression:-
    //"aabbbccccdd" = "a2b3c4d2";"abcc" = "abc2";
    public static String toCompress(String str3){
        String newString = "";
        for(int i =0; i<str3.length(); i++){
            Integer count = 0;//Integer is taken cause ,it can be converted into strings later
            while(i<str3.length() - 1 && str3.charAt(i) == str3.charAt(i+1)){
                count++;
                i++;
            }
            newString += str3.charAt(i);
            if(count > 1){
                newString += count.toString();
            }
        }
        return newString;
    }
    //Compressing the string using String builder:-
    public static String toCompressSb(String str4){
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<str4.length();i++){
            Integer count = 1;
            while(i<str4.length() - 1 && str4.charAt(i) == str4.charAt(i+1)){
                count++;
                i++;
            }
            sb.append(str4.charAt(i));
            if(count > 1){
                sb.append(count);
            }    
        }
        return sb.toString();
    }
    //Count how many lowercase vowels:-
    public static int lowercaseVowel(String str2){
        int count = 0;
        for(int i = 0;i<str2.length();i++){
           char ch = str2.charAt(i);
           if( ch == 'a'|| ch=='e'||ch=='i'||ch=='o'||ch=='u'){
            count++;
           } 
        }
        System.out.println("The no. of vowels is "+ count);
        return count;
    }
    //Check if 2 Strings are anagram:-

    public static void main(String  args[]){

        ;
        //Strings are immutable
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println(name);

        String fullName = "Tony Stark";
        System.out.println(fullName.length());
        //here length is a function so it is imp to use parentesis for length but in arrays

        //Concatenation (joining of strings)
        String firstName = "Ankit";
        String lastName = "Swain";
        String fullName1 = firstName + " "+ lastName;
        System.out.println(fullName1);

        String str1 ="noon";
        System.out.println(isPalindrome(str1));

        String path = "WNEENESENNN";
        shortPath(path);
        
        String str2 = "HelloWorld";
        System.out.println(str2.substring(1,3));//predefined string function
        // System.out.println(substring(str2 , 0 , 5));

        String fruits[] = {"apple","mango","banana","watermelon","aloo"};
        printLargest(fruits);

        //=========STRING BUUILDER ==============/
        StringBuilder sb = new StringBuilder("");
        for (char ch = 'a';ch<= 'z';ch++){
            sb.append(ch);//to add char at end of strings
        }//abcdefghijklmnopqrstuvwxyz
        //0(26)
        //if string used:- 0(n^2)
        System.out.println(sb);

        String str = new String("hi, i am ankit swain");
        System.out.println(toUpperCase(str));
        printLetters(str);

        String str3 = "aaaaabbbbccccddd";
        System.out.println(toCompress(str3));

        String str4 = "kkkkkkkkkkslsllssss";
        System.out.println(toCompressSb(str4));

        lowercaseVowel(str2);
    } 
}