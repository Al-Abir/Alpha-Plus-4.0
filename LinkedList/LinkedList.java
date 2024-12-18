package LinkedList;

public class LinkedList {
    public class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

    }
   // as a properties
    public static Node head; 
    public static Node tail;
    public static int size;

    // method
    public void addFirst(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // 3 step
        newNode.next = head;
        head = newNode;

    }

    public void addLast(int data) {

        // 3 step
        Node newNode = new Node(data);
        size++;
        if (head == null) {
  
            head = tail = newNode;
            return;
        }
   
        tail.next = newNode;
        tail =newNode;
    }

    public void add(int idx, int data){
        if(idx==0){
            addFirst(data);
        }
        Node newNode = new Node(data);
        size++;
        int i =0;
        Node temp = head;
        while(i<idx-1){
             temp = temp.next;
             i++;
        }
        newNode.next = temp.next;
        temp.next = newNode;
    }
    public static int removeFirst(){
        if(size ==0){
            System.out.println("Linked List is Empty");
            return Integer.MIN_VALUE;
        }else if(size ==1){
            int val = head.data;
            head=tail= null;
            size =0;
            return val;
        }
        size--;
        int val = head.data;
        head= head.next;
        return val;
    }
    public static int removeLast(){

        int i;
        Node prev = head;
        for(i =0; i<size-2; i++){
            prev = prev.next;
            i++;
        }
        int val = tail.data;
        prev.next = null;
        tail= prev;
        size--;
        return val;


    }

    public void PintLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("Null");
    }
   
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(4);
        ll.add(2,9);
        System.out.println(ll.size);
        ll.PintLinkedList();
        ll.removeFirst();
        System.out.println(ll.size);
        ll.PintLinkedList();
        ll.removeLast();
        System.out.println(ll.size);
        ll.PintLinkedList();
    }
}
