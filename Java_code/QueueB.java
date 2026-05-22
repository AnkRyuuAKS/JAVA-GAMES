import java.util.*;
public class QueueB{
    // public class Queue{
    //     static Stack<Integer> s1 = Stack<>();
    //     static Stack<Integer> s2 = Stack<>();

    //     public static void isEmpty(){
    //         return s1.isEmpty();
    //     }
    //     //add;
    //     public static void add(int data){
    //         while(!s1.isEmpty()){
    //             s2.push(s2.pop());
    //         }

    //         s1.push(data);

    //         while(!s2.isEmpty()){
    //             s1.push(s2.pop);
    //         }
    //     }

    //     //remove;
    //     public static int remove(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }

    //         return s1.pop();
    //     }
    //     //peek()
    //     public static int peek(){
    //         if(isEmpty()){
    //             System.out.println("queue is empty");
    //             return -1;
    //         }

    //         return s1.peek();
    //     }
    // }

    public static void printNonRepeating(String str){
        int freq[] = new int[26];
        Queue<Character> q = new LinkedList<>();

        for(int i =0 ;i<str.length();i++){
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while(!q.isEmpty() && freq[q.peek() - 'a'] >1){
                q.remove();
            }

            if(q.isEmpty()){
                System.out.println(-1+" ");
            }
            else{
                System.out.println(q.peek() +" ");
            }
        }
        System.out.println();
       }  

    public static void interLeave(Queue<Integer> q){
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for(int i =0; i<size/2;i++){
            firstHalf.add(q.remove());
        }

        while(!firstHalf.isEmpty()){
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
       }

    public static void reverse(Queue<Integer> q1){
        Stack<Integer> s1 = new Stack<>();

        while(!s1.isEmpty()){
            s1.push(q1.remove());
        }

        while(!q1.isEmpty()){
            q1.add(s1.pop());
        }
       }
    public static void main(String args[]){
        // Queue q = new Queue(5);
        Queue<Integer> q = new LinkedList<>();//ArrayDeque 
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);
        interLeave(q);
        while(!q.isEmpty()){
            System.out.print(q.remove() + " ");
        }System.out.println();
        
        Queue<Integer> q1 = new LinkedList<>();//ArrayDeque 
        q1.add(1);
        q1.add(2);
        q1.add(3);
        q1.add(4);
        q1.add(5);
        reverse(q1);
        while(!q1.isEmpty()){
            System.out.print(q1.remove() + " ");
        }System.out.println();

        String str = "aabccxb";
        printNonRepeating(str);
    }
}