package LinkedList;

public class Reverse {
    
    public class Node{
        int data;
        Node next;
        // constructor
        public Node(int data){
            this.data = data;
            this.next = null;
        }
    }
    //Properties
    public static Node head;
    public static Node tail;
    public static int size;
    //method
    public void addFirst(int data){
    Node newNode = new Node(data);
    size++;
    if(head == null){
        head=tail = newNode;
        return;
    }
     //3 step
   
     newNode.next = head;
     head = newNode;
    }
    public void addLast(int data){
       //
       Node newNode = new Node(data);
       size++;
       if(head == null){
         head= tail =newNode;
         return;
       }

       //3 step
      
       tail.next = newNode;
       tail = newNode;

    }

   public void print(){
      if(head == null){
        System.out.println("Linked list is empty");
        
      }
      Node temp = head;
      while(temp!=null){
        System.out.print(temp.data + " -> ");
        temp= temp.next;
      }
   }
   public void reverse(){
      Node prev = null;
      Node curr = tail= head;
      Node next;
      while(curr!=null){
         next = curr.next;
         curr.next = prev;
         prev = curr;
         curr= next;
      }
      head = prev;

   }

    public static void main(String[] args) {
        Reverse ll = new Reverse();

        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.print();
        System.out.println();
        ll.reverse();

        ll.print();
    }
}
