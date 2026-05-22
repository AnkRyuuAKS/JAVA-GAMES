import java.util.*;
public class StackB{
    public static void pushAtBottom(Stack<Integer> s,int data){
        if(s.isEmpty()){
            s.push(data);
            return;
        }

        int top = s.pop();//remove and store in the memory
        pushAtBottom(s,data);//recursion:all the data will be stored in the implicit stack
        s.push(top);
    }
    //Reverse a Sack:
    public static void reverseStack(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        
        int top = s.pop();
        reverseStack(s);//recusrsion
        pushAtBottom(s,top);
    }
    //Reverse a String using Stack:
    public static String reverseString(String str){
        Stack<Character> s1 = new Stack<>();
        int idx = 0;
        while(idx < str.length()){
            s1.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while(!s1.isEmpty()){
            char curr = s1.pop();
            result.append(curr);
        }
        return result.toString();
    }
    //printStack
    public static void printStack(Stack<Integer> s){
        while(!s.isEmpty()){
            System.out.println(s.pop());
        }
    }
    //Static Span Problem:
    public static void stockSpan(int stocks[],int span[]){
        Stack<Integer> s = new Stack<>();
        span[0] = 1;
        s.push(0);

        for(int i = 1 ; i<stocks.length;i++){
            int currPrice = stocks[i];
            while(!s.isEmpty() && currPrice > stocks[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                span[i] = i+1;
            }
            else{
                int prevHigh = s.peek();
                span[i] = i - prevHigh;
            }
            s.push(i);
        }
    }

//=============ISVALID=======

    public static boolean isValid(String str2){
        Stack<Character> s = new Stack<>();

        for(int i = 0;i<str2.length();i++){
            char ch = str2.charAt(i);

            if( ch=='(' || ch == '{' || ch == '['){
                s.push(ch);//opening
            }
            else{//closing
               if(s.isEmpty()){
                return false;//=)))))
               } 

               if( (s.peek() == '(' && ch == ')') 
                    || s.peek() == '{' && ch == '}'
                    || s.peek() == '[' && ch == ']'){
                        s.pop();
                    }else{
                        return false;
                    }
            }
        }
        if(s.isEmpty()){
            return true;
        }else{
            return false;
        }
    }


///=============CHECK DUPLICATE================///

    public static boolean isDuplicate(String str3){
        Stack<Character> s = new Stack<>();

        for(int i =0;i<str3.length();i++){
            char ch = str3.charAt(i);

            //closing
            if(ch == ')'){
                int count = 0;
                while( s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                     return true;//duplicate
                }else{
                    s.pop();//remove the openig pair
                }
            }
            else{
                //opening
                s.push(ch);
            }
        }
        return false; 
    }

    public static void maxArea (int height[]){
        int maxArea = 0;
        int nsr[] = new int[height.length];
        int nsl[] = new int[height.length];

        //Next Smalller right;
        Stack<Integer> s = new Stack<>();

        for(int i =height.length-1; i>=0 ; i--){
            while(!s.isEmpty() && height[s.peek()] >= height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsr[i] = height.length;
            }
            else{
                nsr[i] = s.peek();//top
            }
            s.push(i); 
        }

        //Next Smaller left;
        s = new Stack<>();//empting the stack

        for(int i = 0;i< height.length;i++){
           while(!s.isEmpty() && height[s.peek()] >=   height[i]){
                s.pop();
            }
            if(s.isEmpty()){
                nsl[i] = height.length;
            }
            else{
                nsl[i] = s.peek();//top
            }
            s.push(i); 
        }

        //Current Area:
        for(int i = 0 ; i<height.length ; i++ ){
            int length = height[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = width * length;
            maxArea = Math.max(currArea , maxArea);
        }

        System.out.println("max area in histogram = "+ maxArea);
    }

    public static void main(String args[]){
        
        String str = "HelloWorld";
        String result = reverseString(str);
        System.out.println(result);

        Stack<Integer> s = new Stack<>();
        s.push(1);  
        s.push(2);  
        s.push(3);  
        // printStack(s);//321
        reverseStack(s);
        printStack(s);//123
        
        System.out.println(); 
        int stocks[] = {100,80,60,70,60,85,100};
        int span[] = new int[stocks.length];
        stockSpan(stocks,span);

        for(int i = 0;i<span.length;i++){
            System.out.println(span[i] + " ");
        }
        System.out.println();


        int arr[] = {6,8,0,1,3};
        Stack<Integer> s3 = new Stack<>();
        int nextGreator[] = new int[arr.length];

        for(int i = arr.length-1;i>=0;i--){
            //1while;
            while(!s3.isEmpty() && arr[s3.peek()] <= arr[i]){
                s3.pop();
            }

            //2 if-else;
            if(s3.isEmpty()){
                nextGreator[i] = -1;
            }
            else{
                nextGreator[i] = arr[s3.peek()];
            }

            //3 push in s3
            s3.push(i);
        }
        for(int i =0;i<nextGreator.length;i++){
            System.out.print(nextGreator[i] + " ");
        }
        System.out.println();

        String str2 = "({})[]";
        System.out.println(isValid(str2));

        String str3 = "((a+b))";
        System.out.println("Is it Duplicate "+isDuplicate(str3));
 
        int height[] = {2,1,5,6,2,3};//heights inhistogram
        maxArea(height);


    }
}