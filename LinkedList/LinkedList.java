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

    // method
    public void addFirst(int data) {

        Node newNode = new Node(data);
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
        if (head == null) {
            head = tail = null;
            return;
        }

        tail.next = newNode;
        tail =newNode;
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
        ll.PintLinkedList();
    }
}
