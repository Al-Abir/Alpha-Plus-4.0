package LinkedList;

public class Remove_Nth_Node {
    public class Node {
        int data;
        Node next;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void add(int idx, int data) {
        if (idx == 0) { // If index is 0, add at the beginning
            addFirst(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;

        // Traverse to the node just before the index
        while (i < idx - 1) {
          
            temp = temp.next;
            i++;
        }

        newNode.next = temp.next;
        temp.next = newNode;

        // Update tail if new node is added at the end
        if (newNode.next == null) {
            tail = newNode;
        }
    }
    public static int helper(Node head, int key){
        if(head ==null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next, key);
        if(idx==-1){
            return-1;
        }
        return idx+1;
    }
    public static int Search(int key){
             return helper(head,key);
    }
    public void DeleteNthNode(int n){
        int size =0;
        Node temp = head;
        while(temp!=null){
            temp = temp.next;
            size++;
        }
        if(n==size){
            head = head.next;
        }
        int i =1;
        int findIndex = size-n;
        Node prev  = head;
        while(i<findIndex){
             prev = prev.next;
             i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public void PrintNode() {
        if (head == null) {
            System.out.println("There is no linked list");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Remove_Nth_Node ll = new Remove_Nth_Node();
        ll.addFirst(2);
        ll.addFirst(1);
        ll.addLast(3);
        ll.addLast(5);
        ll.add(3, 4);
        ll.PrintNode();

        ll.DeleteNthNode(3);
        //System.out.println(ll.Search(3));
        ll.PrintNode();
    }
}
