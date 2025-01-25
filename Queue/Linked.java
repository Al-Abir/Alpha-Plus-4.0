package Queue;

public class Linked {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static class Queue {
        private Node head = null;
        private Node tail = null;

        // Check if the queue is empty
        public boolean isEmpty() {
            return head == null;
        }

        // Add an element to the queue
        public void add(int data) {
            Node newNode = new Node(data);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Remove an element from the queue
        public int remove() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            int front = head.data;
            head = head.next;

            // If the queue becomes empty, update tail to null
            if (head == null) {
                tail = null;
            }

            return front;
        }

        // Peek at the front element without removing it
        public int peek() {
            if (isEmpty()) {
                System.out.println("Queue is Empty");
                return -1;
            }

            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();

        q.add(2);
        q.add(34);
        q.add(6);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
