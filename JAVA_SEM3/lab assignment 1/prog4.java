import java.util.Scanner;

public class prog4{
    public static void main(String[] args){
        int[] arr = new int[args.length];

        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(args[i]);
        }

        for(int i = 1;i<arr.length;i++){
            int key = arr[i];//curr
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        System.out.println("Sorted Array:");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }
}