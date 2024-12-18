package LinkedList;

public class Palindrome {
    public class Node {
        int data;
        Node next;

        // Constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

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

    public  Node find_mid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
    }

    public Boolean checkPalindrome() {
        if (head == null || head.next == null) {
            return true;
        }

        // Step 1: Find mid node
        Node mid = find_mid(head);

        // Step 2: Reverse second half
        Node prev = null;
        Node curr = mid;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Compare two halves
        Node right = prev;
        Node left = head;

        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
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
        Palindrome ll = new Palindrome();
        ll.addFirst(1);
        ll.addFirst(1);
        ll.addLast(1);
        // ll.addLast(2);

        ll.PrintNode();
        System.out.println("Is Palindrome? " + ll.checkPalindrome());
    }
}
