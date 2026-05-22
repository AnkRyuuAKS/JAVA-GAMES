public class RecursionBasics{
    public static void decrOrder(int n){
        if(n == 1){
            System.out.println(n);
            return; 
        }
        System.out.print(n  + " ");
        decrOrder(n-1);
    }
    public static void incrOrder(int n){
        if(n == 1){
            System.out.print(n + " ");
            return;
        }
        incrOrder(n - 1);
        System.out.print(n + " ");

    }
    //Factorial of a numb using recursion:-
    public static int factorial(int n){
        if(n == 0){
            return 1;
        }
        int fnm1 = factorial(n - 1);
        int fn = n *  fnm1;
        return fn;
    }
    //Sum of first n natural n0,:-
    public static int sumOfNNum(int n){
        if(n == 1){
            return 1;
        }
        int snm1 = sumOfNNum(n-1);
        int sum = n + snm1;
        return sum;
    }
    //FIBONNACI NUMBER:-
    public static int fib(int n){
        if( n == 0 || n ==1){
            return n;
        }
        int fnm1 = fib(n-1);
        int fnm2 = fib(n-2);
        int fn = fnm1 + fnm2;
        return fn;
    }
    //to check if array is sorted:-
    public static boolean checkSortArr(int arr[],int i){
        if(i == arr.length -1){//base point
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        boolean a = checkSortArr(arr , i+1);
        return a;
    }
    //First occurance:-
    public static int firstOccur(int arr1[],int i ,int key){
        if(arr1[i] == key){
            return i;
        }
        if(arr1[arr1.length-1] == key){
            return -1;
        }
        return firstOccur(arr1,i+1,key);
    }

    //Last Occurance:-
    public static int lastOccur(int arr1[],int i,int key){
        if(i == arr1.length -1){//Base point
            return -1;
        }
        //first go forward 
        int lastOccur = lastOccur(arr1,i+1,key);
        if(lastOccur  != -1){
            return lastOccur;
        }

        //check with self
        if(arr1[i] == key){
            return i;
        }
        return -1;
    }

    //print x^n:-
    public static int xPowN(int x , int n ){
        if(n == 1){
            return x;
        }
        int xPowN = x * (xPowN(x,n-1));
        return xPowN;
    }
    //Optimized power of x and n:-
    public static int optimizedPower(int x,int n){//O  (logn)
        if( n == 0){
            return 1;
        }
        int halfPowSq = optimizedPower(x,n/2) * optimizedPower(x,n/2);
        //For n is odd:
        if(n % 2 != 0){
            halfPowSq = x * halfPowSq;
        }

        return halfPowSq;
    }
    public static void main(String args[]){
        decrOrder(19);
        incrOrder(10);
        System.out.println(factorial(5));
        int n = 5;
        System.out.println(sumOfNNum(n));

        System.out.println("the fibonnacci of n is " + fib(15));

        int arr[] = {1,2,3,4,5};
        System.out.println(checkSortArr(arr,0));

        int arr1[] ={8,3,9,6,5,10,2,5,3};
        System.out.println("the first Occurance "+firstOccur(arr1,0,5));
        System.out.println("the  Last Occurance "+lastOccur(arr1,0,5) );

        System.out.println("x^n ="+xPowN(2,10));
        System.out.println("Optimized x^n ="+optimizedPower(2,10));
    }
}