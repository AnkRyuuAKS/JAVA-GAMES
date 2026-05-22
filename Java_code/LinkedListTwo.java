import java.util.LinkedList;
public class LinkedListTwo{
    public static class Node {
        Node next;
        int data;

        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    public static Node head;
    public static Node tail;
    
    public static Node getMid(Node head){
        Node slow = head;
        Node fast = head.next;

        while(head != null && head.next != null){
            slow = slow.next;
            head = head.next.next;
        }
        return slow;//mid
    }
    public  static Node merge(Node head1 ,Node head2){
        Node mergeLL = new Node(-1);
        Node temp = mergeLL;

        while(head1 != null && head!= null){
            if(head1.data <= head2.data){
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next;
            }
            else{
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        }

        while(head1 != null){
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }
        while(head2 != null){
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }

        return mergeLL.next;
    }
    public static Node mergeSort(Node head){
        if(head == null || head.next == null){
            return head;
        }
        //find mid
        Node mid = getMid(head);
        //left & right MS
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft,newRight);
    }

    public static void zigZag(){
        //find mid
        Node slow = head;
        Node fast = head.next;
        while( fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        //reverse the right part;
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL , nextR;

        //alt merge -> zig - zag merge
        while(left != null && right != null){
           nextL = left .next;
           left.next = right;
           nextR = right.next;
           right.next = nextL;

           left = nextL;
           right = nextR;  
        }

    }
    public static void main(String args[]){
        //create;
        LinkedList<Integer> ll = new LinkedList<>();
        //add;
        ll.addFirst(1);
        ll.addFirst(2);
        ll.addLast(4);
        ll.addFirst(3);
        ll.addLast(5);
        System.out.println(ll);
         mergeSort(head);
        System.out.println(ll);
        zigZag();
        System.out.println(ll);


        //remove;
        // ll.removeFirst();
        // ll.removeLast();
        System.out.println(ll);


       
    }
}