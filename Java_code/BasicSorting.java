import java.util.*;

public class BasicSorting{
    //BUBBLE SORTING
    public static void bubbleSort(int arr[]){
        for (int turn = 0; turn<arr.length -1 ;turn++){
            for(int j = 0; j<arr.length -1-turn; j++){
                int swap=0;
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                swap++;
                }System.out.println(swap); 
            }
        }
    }
    //optimised bubble sort;
    public static void optimisedBubbSort(int arr[]){
        for (int turn = 0; turn<arr.length -1 ;turn++){
        boolean swaped = false;
            for(int j = 0; j<arr.length -1-turn; j++){
                int swap=0;
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaped = true;
                swap++;
                }
            }
            if(swaped == false){
                break;
            }    
    }
    public static void printArr(int arr[]){
        for(int i =0;i<arr.length;i++){
            System.out.print(arr[i] + " ");
        }
    }

//Selection sort:-
    public static void Selectsort(int arr[]){
        for(int i = 0;i<arr.length-1;i++){
            int minPos = i;
            for(int j = i+1;j<arr.length;j++){
               if(arr[minPos] >arr[j]){ //just have to change the > to < for descending order
                minPos = j;
               }
               //swap
               int temp = arr[minPos];
               arr[minPos] = arr[i];
               arr[i] = temp;

            }
        }
    }

//Insertion Sorting:-
    public static void insertionSort(int arr[]){
        //we have to sort n-1 element in sorted part
        for(int i = 1 ;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            //Finding out the correct pos to insert
            while(prev >=0 && arr[prev] > curr){
                //To bring it in descending order just change the while condition
                arr[prev+1] = arr[prev];
                prev--;
            } 
            //insertion 
            arr[prev + 1] = curr;
        }
    }

//============COUNTING SORTING ==============
    public static void CountingSort(int arr[]){
        int largest = Integer.MIN_VALUE;
        for (int i = 0;i<arr.length;i++){
            largest = Math.max(largest,arr[i]);
        } 

        int count[] = new int[largest+1];
        for(int i = 0;i<arr.length;i++){
            count[arr[i]]++;
            //increament of value in count
        }

        //Sorting
        int j=0;
        for(int i =0;i<arr.length;i++){
            while(count[i] > 0){
                arr[j] = i;
                j++;
                count[i]--;
            }
        }
    }

//==========DESCENDING ORDER SORTING ===============//
    public static void descbubbleSort(int arr[]){
        for(int i =0;i<arr.length-1;i++){//i = turns(n-2)
             for(int j = 0;j<arr.length-1-i;j++){
                 if(arr[j] < arr[j+1]){
                    int temp = arr[j];
                    arr[j]= arr[j+1];
                    arr[j+1]=temp;
                 }
             }
        }
    }
    public static void descSelectsort(int arr1[]){
        for(int i=0;i<arr1.length;i++){
            int minPos=i;
            for(int j=i+1;j<arr1.length;j++){
                if(arr1[minPos]<arr1[j]){
                    minPos = j;
                }
                int temp = arr1[i];
                    arr1[i]=arr1[minPos];
                    arr1[minPos]=temp;
            } 
        }
    }
    public static void descInsertionSort(int arr1[]){
        for(int i=0;i<arr1.length;i++){
            int curr = arr1[i];
            int prev = i-1;
            while(prev >=0 && arr1[prev] < curr){
                //To bring it in descending order just change the while condition
                arr1[prev+1] = arr1[prev];
                prev--;
            } 
           arr1[prev+1]=curr; 
        }
    }
    public static void descCountsort(int arr1[]){
        //For finding out the range:
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr1.length;i++){
            largest = Math.min(largest,arr1[i]);
        }
        //for updating the count array
        int count[] = new int[arr1.length];
        for(int i =0;i<arr1.length;i++){
            count[arr1[i]]++;
        }
        //Sorting
        int j=arr1.length-1;
        for(int i=0;i<arr1.length;i++){
            while(count[i]>0){
                arr1[j]=i;
                j--;
                count[i]--;
            }
        }
    }
    public static void printArr1(int arr1[]){
        for(int i =0;i<arr1.length;i++){
            System.out.print(arr1[i] + " ");
        }
    }
    public static void main(String args[]){
        int arr1[] = {3,6,2,1,8,7,4,5,3,1};
        // CountingSort(arr);
        //  descbubbleSort(arr1);
        // descSelectsort(arr1);
        // descInsertionSort(arr1);
        descCountsort(arr1);
         printArr1(arr1);
        // insertionSort(arr);  
        

    }
}