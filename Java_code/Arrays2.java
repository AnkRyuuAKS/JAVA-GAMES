import java.util.*;

public class Arrays2{

 //Max Subarray Sum:-PREFIX SUM 
    public static void maxprintSubarray(int numbers[]){
        int currSum =0;
        int largest = Integer.MIN_VALUE;
        int prefix[] = new int[numbers.length];

        prefix[0] = numbers[0];
        //calculate prefix 
        for(int i =1 ;i<numbers.length;i++){
            prefix[i] = prefix[i-1] + numbers[i];
            //above- it is the formulae to calulate the prefix array
        }

        for(int i=0;i<prefix.length;i++){
            int start = i;
            for(int j=i ;j<numbers.length;j++){
                int end = j;
                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start-1];

                if(largest<currSum){
                    largest = currSum;
                }
            }
        }
        System.out.println("the max sum is:"+largest);
     }

     //Kadanes algoritm
     //the speed of execution or the time period is highest
     public static void kadanes(int numbers[]){
        int ms = Integer.MIN_VALUE;
        int cs =0;

        for(int i =1; i<numbers.length;i++){
            cs = cs+ numbers [i];
            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
        }

        System.out.println("our max sum(kadanes) :"+ms);
     }
//For only -ve num KADANES//WRONG
    public static void negkad(int numbers[]){
        int smallest = Integer.MAX_VALUE;
        for(int i =0; i<numbers.length; i++){
            if (smallest>numbers[i]){
                smallest = numbers[i];
            }
        }System.out.println("-"+smallest);

    }
    
    //Trapping rainwater TC-o(n)
    public static int trappedRainwater(int height[]){
        int width = 1; 

        //Auxilary Arrays:-
        //calculate left max boundry -array
        int leftMax[] = new int[height.length];
        leftMax[0] = height[0];
        for(int i = 1; i<height.length; i++)
        {
            leftMax[i] = Math.max(height[i] , leftMax[i-1]);
        }

        //Calculate right max boundry  -array
        int rightMax[] = new int[height.length];
        rightMax[height.length - 1] = height[height.length - 1];
        for(int i =(height.length - 2) ;i>=0; i--){
            rightMax[i] = Math.max(height[i] , rightMax[i+1]);
        }
        int trappedWater =0;
        //loop  
        for(int i =0 ;i<height.length; i++){
            //waterLevel = Math.min(leftmax bpoundary , rightMax boundary)
            int waterLevel = Math.min(leftMax[i],rightMax[i]);

            //trapped water = water level- height[i]
            trappedWater += (waterLevel -height[i]) * width;
        }

        return trappedWater;
    }
    public static int trappedRainwater2(int height[]){
        int left = 0,right = height.length -1;
        int rainwater = 0;
        int  rightM = 0,leftMax = 0;
        while(left <= right){//there must be someone greater than the current left array or it might be the largest itself
            if(left <= right){
                leftMax = Math.max(leftMax,height[left]);
                rainwater += (leftMax - arr[left]);
                left++;
            }else{
                rightM = Math.max(rightM,height[right]);
                rainwater += (rightM - arr[right]);
                right--;
            }
        }
        return rainwater;
    }

//BYING AND SELLING STOCKS:-  
    public static int buyAndSellStocks(int prices[]){
       int buyPrice = Integer.MAX_VALUE;
       int maxProfit = 0 ;

       for (int i = 0; i<prices.length;i++){
        if(buyPrice < prices[i]){
            int profit = prices[i] - buyPrice;
            maxProfit = Math.max(maxProfit,profit);
        }else{
            buyPrice = prices[i];
        }
       }

       return maxProfit;
    }

    public static void main(String args[]){
        int numbers[] = {-2,-3,-1,4,-2,-3};
        maxprintSubarray(numbers);
        kadanes(numbers);
        negkad(numbers);
        
        int height[] = {4,2,0,6,3,2,5};
        System.out.println("The amout of rainwater trapped " +trappedRainwater(height));

        int prices[] = {7,1,5,3,6,4};
        System.out.println("maxProfit is : "+buyAndSellStocks(prices));

    }
}
