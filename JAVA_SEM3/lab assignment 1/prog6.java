import java.util.*;

public class prog6{
    public static void main(String[] args){
        int[] arr = new int[args.length];

        for(int i = 0;i<arr.length;i++){
            arr[i] = Integer.parseInt(args[i]);
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to be checked using searching");
        int n = sc.nextInt();
        Arrays.sort(arr);
        int low = 0,high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == n) {
                System.out.println(n + " is present in the array.");
                return;
            } else if(arr[mid] < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        System.out.println(n + "is not present in the array.");
        sc.close();
    }
}