public class LinkedList{

    public static class Node{
        int data;
        Node next;

        public Node(int data){//constructer
              this.data = data;
              this.next = null;
        }
    } 
    public static Node head;
    public static Node tail;
    public static int size;//dafault-0;

    public void addFirst(int data){
        //step -1: Create new node  
        Node newNode = new Node(data);
        size++;
        if(head == null){
            head = tail = newNode;
            return;
        }

        //step -2:linking of the next to the head
        newNode.next = head;//this step is the basis of linked list
        //the address of head is stored in next of newNode;

        //step-3 :head = newNode;
        head = newNode; 
    }

    public void addLast(int data){
        Node newNode = new Node(data);//step-1
        size++;

        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;//step-2
        tail = newNode;//step-3
    }

    public void print(){
        if(head == null){
            System.out.print("LL is empty");
        }
        Node temp = head;//storing the head in temp
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("  null");
    } 

    public void addInx(int idx,int data){
        if(idx == 0){
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);//node that is to be added
        size++;

        //assign temp as head and keep on increasing the temp;
        Node temp = head;
        int i = 0;

        while(i<idx-1){
            temp = temp.next;//to keep on moving
            i++;
        }

        //i=idx-1; temp ->prev
        newNode.next = temp.next;
        temp.next = newNode; 
    }

    public int removeFirst(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val; 
    }
    public int removeLast(){
        if(size == 0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } 
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        //prev = size-2(2nd last);
        Node prev = head;
        for(int i =0;i<size-2;i++){
            prev = prev.next;
        }
        
        int val = prev.next.data;//tail.data
        prev.next = null;
        tail = prev;
        size--; 
        return val;
    }

    //Search(iteration):
    public int itrSearch(int key){
        Node temp = head;
        int i =0;

        while(temp != null){
            if(temp.data == key){
                return i;
            }
            temp = temp.next;
            i++;
        }

        //key not found;
        return -1;
    }
 //Search in arecursive manner;
    public int helper(Node head,int key) {
        if(head == null){
            return -1;
        }

        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next,key);
        if(idx == -1){
            return -1;
        }
        else{
            return idx+1;
        }
    }  
    public int recSearch(int key){
        return helper(head,key);
    }

//REVERSE:
    public void reverse(){
        //4 variables:
        Node prev = null;
        Node curr = tail = head;
        Node next;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }    

//Delete nth from the end:
    public void deleteNthfromEnd(int n){
        //calculate size;
        int sz = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            sz++;
        }

        if(n == size){
            head = head.next;//remove First
            return;
        }

        //sz-n;
        int i = 1;
        int iToFind = sz-n;
        Node prev = head;
        while(i < iToFind){
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;

    }

//SLOW - FAST APPROACH:
    public Node findMid(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;//1+
            fast = fast.next.next;//2+
        }
        return slow; //slow is my midNode
    }
    public boolean checkPalindrome(){
        if(head == null || head.next == null){
            return true;
        }
        //step -1 :find the mid
        Node midNode = findMid(head);

        //step -2:reversr();
        Node prev = null;
        Node curr = head;
        Node next;
        while( curr!= null){
            next = curr.next;
            prev = curr;
            curr = next;
        }
        Node right = prev;
        Node left = head;

        //step-3:check if left half and right half
        while( right != null){
            if(left.data != right.data){
                return false; 
            }
            left = left.next;
            right = right.next;
        }

        return true;

    }

     public static boolean isCycle(){
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;//+1
            fast = fast.next.next;//+2
            if( slow == fast){
                return true;//cycle exists
            }
        }

        return false;//cycle dosent exist
    }

    public static void removeCycle(){
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while( fast != null && fast.next == null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                cycle = true;
                break;
            }
        }
        if(cycle == false){
            return;
        }

        //find meeting point:
        slow = head;
        Node prev = null;//last node
        while(slow != fast){
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        //remove cycle ->last.next = null;
        prev.next = null;
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

    //to find the point of merging of two lists;
    public Node getIntersectionPoint(Node head1 , Node head2){
        while(head2 != null){
            Node temp = head1;
            while(temp != null){
                if(temp == head2){
                    return head2;
                }
                temp = temp.next;
            }
            head2 = head2.next;
        }
        return null;
    }
    public static void main(String args[]){
        LinkedList ll = new LinkedList();
        // ll.print();
        ll.addFirst(2);
        // ll.print();
        ll.addFirst(1);
        // ll.print();
        ll.addLast(3);
        // ll.print();
        ll.addLast(4);
        // ll.print();

        ll.addInx(2,9);
        ll.print();
        System.out.println(size);

        ll.removeFirst();
        ll.print();

        ll.removeLast();
        ll.reverse();//for revrsing the Linked List
        ll.deleteNthfromEnd(2); 
        ll.print();

        System.out.println("Found at : "+ll.itrSearch(3));
        System.out.println("Found at(through recurs) : "+ll.recSearch(10));
        
        ll.zigZag();
        ll.print();
        // //new one;
        // LinkedList ll2 = new LinkedList();
        // ll2.addLast(1);
        // ll2.addLast(2);
        // ll2.addLast(2);
        // ll2.addLast(1);

        // ll2.print();
        // System.out.println(ll2.checkPalindrome());

        //  head = new Node(1);
        // Node temp = new Node(2);
        // head.next= temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // // 1-2-3-2
        
        System.out.println(isCycle());
        removeCycle();
        System.out.println(isCycle());
    }      
}
