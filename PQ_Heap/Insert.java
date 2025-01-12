package PQ_Heap;

import java.util.ArrayList;

public class Insert {

    static class Heap {
        ArrayList<Integer> arr = new ArrayList<>();

        // Add method to insert elements and maintain the min-heap property
        public void add(int data) {
            // Add the new element at the end of the array
            arr.add(data);
            int x = arr.size() - 1; // Index of the newly added element
            int par = (x - 1) / 2;  // Index of its parent

            // Bubble up to maintain the min-heap property
            while (x > 0 && arr.get(x) < arr.get(par)) {
                // Swap the current node with its parent
                int temp = arr.get(x);
                arr.set(x, arr.get(par));
                arr.set(par, temp);

                // Update indices
                x = par;
                par = (x - 1) / 2;
            }
        }

        // Method to print the heap
        public void printHeap() {
            System.out.println(arr);
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap();

        // Insert elements into the heap
        heap.add(5);
        heap.add(3);
        heap.add(10);
        heap.add(1);

        // Print the heap
        heap.printHeap();
    }
}
