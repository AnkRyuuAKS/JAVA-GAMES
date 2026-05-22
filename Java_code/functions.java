import java.util.*;
public class functions{
    //PRINTING Hello world;
    public static void printHelloWorld(){
            System.out.println("Hello world");
    }
    //Printing sum of three numbers
    public static int calculateSum(int a,int b,int c){
        int sum = a+b+c;
        return sum;
    }
    //finding avg of 3 numbers
    public static int average_3No(int a, int  b,int c){
        int avg =(a+b+c)/3;
        return avg;
    }
    //Check whether the number is even
    public static boolean isEven(int n){
        boolean isodd=false;
        if(n%2==0){
             isodd=true;
        }
        return isodd;
    }
    //Check the palandrome of the number
    public static boolean palindrome(int n){
        int actualNo =n;int reverseNo=0;
        while(n>0){
        int lastDigit = n%10;
         reverseNo = reverseNo*10 +lastDigit ;
        n=n/10;
        }
        if(reverseNo == actualNo){
           return true;
        }else{

        return false;
        }
    }
    //Printing sum of all digits of a number
    public static int sum_Digit(int n){
        int sum=0;
        while(n>0){
        int lastDigit =n%10;
        n=n/10;
        sum =sum+lastDigit;
        }
        return sum;
    }
    //swapping two numbers
    public static void swap(int num1,int num2){
        int temp = num1;
        num1=num2;
        num2=temp;
        System.out.println("num1 is" +num1);
        System.out.println("num2 is" +num2);

    }
    //finding out the factorial of the number
    public static int factorial(int n){
        int f=1;
        for(int i=1;i<=n;i++){
            f=f*i;
        }
        System.out.println("factorial "+" "+f);
        return f;
    }
    //BINOMIAL FACTORS
    public static int binofact(int n ,int r){
        int nfact=factorial(n);
        int rfact=factorial(r);
        int nmrfact=factorial(n-r);
        int bf =nfact/(rfact*nmrfact);
        return bf;
    }

//prime no. can be checked through normal or optimised methods
    public static boolean isPrimr(int n){
        boolean isPrime =true;
        if(n==1){//corner case: outside the loop
            isPrime=true;
        }
        for(int i=2;i<=n-1;i++){
            if(n%i==0){
                isPrime= false;
                break;
            }
        }
        return isPrime;
    }

    //PRINT PRIME NO. IN RANGE
    public static void primrInRange(int n){
        for(int i=2;i<=n;i++){
            if(isPrimr(i)==true ){
                System.out.print(i+" ");
            }
        }
        return;
    }
    //FIBONACCI NUMBERS:-
    public static void fibonacci(int n){
        int n1=0,n2=1,n3;
        System.out.print(n1+" "+n2);
        for(int i =1;i<=n;i++){
            n3 = n1+n2;
            n2 = n3;
            n1 = n2;
        System.out.print(" "+ n3);
        }
    }

    public static void main(String args[]){
        // body
        printHelloWorld();//this is function call
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
          int sum=calculateSum(a,b,c);
          System.out.println("THe avg of a,b,c:"+average_3No(5,6,6));
           System.out.println("Sum of a,b,c:"+ sum);
        int num1= sc.nextInt();
        int num2=sc.nextInt();
          swap(num1,num2);
        int n=5;
        int r=3;
          factorial(n);
          System.out.println("Binomial factorial is"+binofact(n,r));
        System.out.println(isPrimr(10));
        System.out.println("Is the number even:"+isEven(455));
        primrInRange(16);
        System.out.println(palindrome(121));
        System.out.println("sum of digits"+sum_Digit(12234));
        
        fibonacci(10);

    }
}