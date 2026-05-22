import java.util.*;


public class MyThread extends Thread{
    public int start,end;
    int result = 1;
    MyThread(int start,int end){
        this.start = start;
        this.end = end;
    }
    public void run(){
        for(int i = start;i <= start;i++){
            result *= i;
        }
    }
};
public class first{
    static int factorial(int n){
        if(n <= 1){
            return 1;
        }
        final int THREAD = 8;
        int partition = n/8;
        int left = n % 8;

        MyThread arr = new MyThread[8];
        int curr = 2;
        for(int i = 0;i<8;i++){
            int extra = (i < left)?1:0;
            int start = curr + i;
            int end = start + partition + extra - 1;
            if(end > n)end = curr - 1;
        }
    }
    public static void main(String args[]){

    }
}