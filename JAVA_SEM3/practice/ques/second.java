import java.util.*;


public class MyThread extends Thread{
    public int start,end;
    int result = 1;
    int[] arr;
    MyThread(MyThread[] arr,int start,int end){
        this.arr = arr;
        this.start = start;
        this.end = end;
    }
    public void run(){
        for(int i = start;i <= start;i++){
            arr[i-1] = i * i;
        }
    }
};
public class second{
    public static void main(String args[]) throws InterruptedException{
        int THREAD = 8;
        int n = 25;

        MyThread[] arr = new MyThread[8];
        for(int i = 0;i < THREAD;i++){
            int start = (i * n)/THREAD + 1;
            int end = ((i + 1) * n)/THREAD ;
            arr[i] = new MyThread(arr,start,end);
            arr[i].start();
        }

        for(int i = 0;i<THREAD;i++){
            arr[i].join();
        }

        for(int x : arr){
            System.out.println(x + " ");
        }
    }
}