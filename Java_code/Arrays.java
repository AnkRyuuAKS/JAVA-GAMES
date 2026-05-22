import java.util.*;

public class Arrays{
  public static void update(int marks[]){
    for(int i=0;i<marks.length ;i++){
      marks[i]=marks[i]+1;

    }
  }

  public static int linearSearch(int marks[],int key){
    for(int i=0; i<marks.length ;i++){
      if(marks[i]== key){
        return i;
      }
    }
      return -1;
  }

  public static int getLargest(int number[]){
    int largest = Integer.MIN_VALUE;//-infinity
    int smallest =Integer.MAX_VALUE;//+infinity
    for(int i=0; i<number.length; i++){
      if(largest< number[i]){
        largest = number[i];
      }
      if(smallest>number[i]){
        smallest = number[i];
      }
    }
    System.out.println("Smallest value is"+smallest); 
    return largest;
  }

  //BINARY SEARCHING(also known as dictionary search)
  public static int binarySearch(int numbers[],int key){
    int start=0; int end=numbers.length-1; 

    while(start<=end){
      int mid =(start+end)/2;
      //comaprision
      if(numbers[mid]== key){
        return mid;
      }
      if(numbers[mid] <key){//right
        start = mid+1;
      }
      if(numbers[mid] > key){//left  
        end = mid -1;
      }
    }
    return -1;
  }

  //Reverse an array
  public static void reverse(int numbers[]){
    int first =0; int last =numbers.length -1;

    while(first < last){
      int temp = numbers[last];
      numbers[last]=numbers[first];
      numbers[first]=temp;

      first++;
      last--;
    }
  }

 //To print pairs of array
public static void printPairs(int numbers[]){
  int tp =0;
  for (int i=0; i<numbers.length;i++){
    int curr = numbers[i];
    for(int j=i+1;j<numbers.length;j++){
      System.out.print("(" + curr+ "," + numbers[i]+")");
      tp++;
    }
    System.out.println();
  }
  System.out.println("Total numbers of pairs:"+ tp);
 }

//Print SubArrays
public static void printSubarrays(int numbers[]){
  int tsa =0;
  for(int i= 0;i<numbers.length;i++){
    int start = i;
    for(int j = i; j<numbers.length;j++){
      int end= j;
      for(int k=start;k<=end;k++){
        System.out.print(numbers[k]+" ");
        tsa++;
      }
      System.out.println();
    }
  }
    System.out.println("Total subarrays are"+tsa);
}

//Max-SubArray sum-1
public static void maxSubarraySum(int numbers[]){
  int currSum = 0;
  int maxSum = Integer.MIN_VALUE;

  for(int i= 0; i<numbers.length;i++){
    int start = i;
    for(int j = i; j<numbers.length;j++){
      int end= j;
      currSum=0;
      for(int k=start;k<=end;k++){
        //subarrays
        currSum +=numbers[k];
      }
      System.out.println("The sum of arrays:"+currSum);
      if(maxSum < currSum){
        maxSum = currSum;
      }
    } 
  } 
  System.out.println("max-sum ="+maxSum);
}

  public static void main(String args[]){
    int marks[] = {2,4,6,8,10,12,14,16};
    int key =10;
    int index=linearSearch(marks,key);  
    if(index==-1){
      System.out.println("Not in the arrays");
    }
    else{
      System.out.println("key is at index:"+index);
    }

    int number[]={1,2,6,3,5};
    System.out.println("The largest number is"+getLargest(number));
    
    int numbers[]={2,4,6,8,10,12,14,16 };
    System.out.println("index for key is:" + binarySearch(numbers,key));

    reverse(numbers);
    //To print the number
    for(int i=0; i<numbers.length; i++){
      System.out.print(numbers[i]+" ");
    }
    System.out.println();

    printPairs(numbers);
    printSubarrays(numbers);

    maxSubarraySum(numbers);
  }
}

