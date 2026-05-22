import java.util.*;
public class DivideAndConquer{
    public static void printArr(int arr[]){
        System.out.print("Merge sort-");
        for(int i = 0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void printArr1(int arr1[]){
        System.out.print("Quick sort-");
        for(int i = 0;i<arr1.length;i++){
            System.out.print(arr1[i]+" ");
        }
        System.out.println();
    }
    public static void printArr2(String arr3[]){
        for(int i = 0;i<arr3.length;i++){
            System.out.print(arr3[i]+" ");
        }
        System.out.println();
    }
//MERGING SORT:-
   public static void mergeSort(int arr[],int si,int ei){
    //Base case;
    if(si >= ei){
        return;
    }
    int mid = si + (ei-si)/2;//(si+ei)/2
    mergeSort(arr,si,mid);//left
    mergeSort(arr,mid+1,ei);//right

    //create a new function for merging
    merge(arr,si,mid,ei);
   }

   public static void merge(int arr[],int si,int mid,int ei){
    //left(0,3)=4 right(4,6)=3  /6-0+1=7/
    int temp[] = new int[ei-si+1];
    int i = si;//iterator for left part
    int j = mid +1;//iterator for right part
    int k = 0;//for iterating temp arr

    while( i<= mid && j<= ei){
        if(arr[i] < arr[j]){
            temp[k] = arr[i];
            i++;
        }
        else{
            temp[k] = arr[j];
            j++;
        }
        k++;
    }

    //All the left out conditions because of use of &-operat above loop
    while(i<= mid){//left part
        temp[k++] = arr[i++];
    }

    while(j<= ei){//right part
        temp[k++] = arr[j++];
    }

    //to copy the temp elem in original arr;
    for(k=0,i=si;k<temp.length;k++,i++){
        arr[i] = temp[k];
    }
   }



// ============QUICK SORTING=================//

   public static void quickSort(int arr1[],int si,int ei){
    //Base case;
    if(si >= ei){
        return;
    }
    int piIn = partition(arr1,si,ei);
    //recursion;
    quickSort(arr1,si,piIn-1);//left
    quickSort(arr1,piIn+1,ei);//right

   }
   public static int partition(int arr1[] ,int si,int ei){
    int pivot = arr1[ei];
    int i = si-1;//-1

    for(int j = si; j < ei;j++){//why si
        if(arr1[j] < pivot){
            i++;
            //swap
            int temp = arr1[j];
            arr1[j] = arr1[i];
            arr1[i] = temp;
        }
    }
    i++;
    int temp = pivot;
    arr1[ei] = arr1[i];//not pivot=arr[i] as pivot is a variable
    arr1[i] = temp;
    return i;
   }

//Modified Binary search;=
    public static int search(int arr2[],int tar,int si,int ei){
        //base case;
        if(si>ei){
            return -1;
        }
        int mid = si+(ei - si)/2;

        //Case Found;
        if(arr2[mid] == tar){
            return mid;
        }

        //mid on L1;
        if( arr2[si] <= arr2[mid]){
            //case a:left
            if(arr2[si] <= tar && tar<= arr2[mid]){
                return search(arr2,tar,si,mid-1);//left recursion
            }
            else{
                //casse b :right
                return search(arr2,tar,mid+1,ei);
            }
        }

        //mid on l2;
        else{
            //case c : right;
            if(arr2[mid] <= tar && tar <= arr2[ei]){
                return search(arr2,tar,mid+1,ei);
            }
            else{
                //case d: left;
                return search(arr2,tar,si,mid-1);
            }
        }
    }
    //Merge sort type 2;
    public static void mergeSortTwo(String arr3[],int si,int ei){
        //Base case;
        if(si >= ei){
            return;
        }
        //divide
        int mid = (si+ei)/2;
        mergeSortTwo(arr3,si,mid);//left recursion
        mergeSortTwo(arr3,mid+1,ei);//right recursion

        merge2(arr3,si,ei,mid);//merging of smallr arr 
       
    }
    public static void merge2(String arr3[],int si, int ei,int mid){

        String temp[] = new String[ei-si+1];
        int i = si;//for left iteration
        int j = mid+1;//iteration of right 
        int k = 0;//for temp

        while(i<= mid && j<= ei){
            if(isAlphabeticallySmaller(arr3[i],arr3[j])){
                temp[k] = arr3[i];
                i++;k++;
            }
            else{
                temp[k] = arr3[j];
                j++;k++;
            }
        }
        
        while(i<=mid){
            temp[k++] = arr3[i++];
        }
        while(j<=ei){
            temp[k++] = arr3[j++];
        }

        //copy temp into arr3;
        for(i=si,k=0;k<temp.length;k++,i++){
            arr3[i] = temp[k];
        }
    }

    public static void main(String args[]){
        int arr[]={6,3,9,5,2,8,-2,-4};
        mergeSort(arr,0,arr.length-1);
        printArr(arr);

        int arr1[]= {6,3,9,8,2,5};
        quickSort(arr1,0,arr1.length-1);
        printArr1(arr1);
        
        int arr2[] = {4,5,6,7,0,1,2};
        int tarIdx = search(arr2,0,0,arr.length-1);
        System.out.println(" on index :"+tarIdx);
        
        String arr3[] = {"sun","moon","mercury","mars"};
        mergeSortTwo(arr3,0,arr3.length -1);
        printArr2(arr3);
    }

}