import java.util.*;
//==============Bit wise operator=============//
public class BitManup{
    public static void deciToBinary(int num){
        int bin = 0;
        int  pow =0;
        while (num>0){
            int rem = num%2;
            bin = bin +(rem * (int)Math.pow(10,pow));
            pow++;
            num = num/2;
        }
        System.out.println(bin);
    }
    //Check odd or even by binary numbers
    public static void oddOrEven(int n){
        int bitMask = 1;
        if((n & bitMask) == 0){
            System.out.println("Even Number");
        }
        else{
            System.out.println("odd number");
        }
    }
    //Get ith bit:-
    public static int getIthBit(int n,int i){
        int bitMask = (1<<i);
        if((n & bitMask) == 0){
            return 0;
        }
        else{
            return 1;
        }
    }
    public static int setIthBit(int n ,int i){
        return n | (1<<i); 
    }
    //Clear the bit in ith position:-
    public static int clearIthBit(int n , int i){
        int bitMask = ~(1<<i);
        return n & bitMask;
    } 
    //upadate ith bit:-
    public static int upadateIthBit(int n ,int i ,int newBit){
        n =  clearIthBit(n,i);
        int bitMask = newBit << i;
        return n | bitMask;
    }
    //Clear Last i Bits:-
    public static int clearLastIBits(int n,int i){
        int bitMask =(~0)<<i;
        return n & bitMask;
    }

    //Clear Range of bit:
    public static int clearRangeIBit(int n,int i,int j){
        int a = ((~0)<<(j+1));
        int b = ((1<<i) - 1);
        int bitMask = a | b;
        return n & bitMask;
    }

    //Check if a number is power of 2:-
    public static boolean isPowerOfTwo(int n){
        return (n & (n-1)) == 0;
    }

    //Count set Bits in a number:-
    public static int countSetBits(int n){
        int count = 0;
        while(n > 0){//check the LSB
            if((n & 1) != 0 ){
                count++;
            }
            n = n>>1;//right shift
        }
        return count;
    }

    //Fast exponentation :-
    public static int fastExponent(int a,int n){
        int ans = 1;
        while(n>0){
            if((n & 1) != 0){
                ans = ans * a;
            }
            else{
                ans = ans * 1;
            }
            a = a*a;
            n = n>>1;
        }
        return ans;
    }
    public static void main(String args[]){
        deciToBinary(45);
        System.out.println("the XOR of"+(5^6));
        oddOrEven(45);
        System.out.println("the ith no.:"+getIthBit(10,3));
        System.out.println(setIthBit(10,2));
        System.out.println(clearIthBit(10,1));
        System.out.println(clearLastIBits(15,2));
        System.out.println(upadateIthBit(10,2,1));
        
        System.out.println(clearRangeIBit(101,2,11));

        System.out.println(isPowerOfTwo(23));

        System.out.println(countSetBits(15));

        System.out.println("the ans of a^n:"+fastExponent(15,15));
    }
}