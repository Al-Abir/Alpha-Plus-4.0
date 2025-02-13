package Segment_Tree;

public class Creation {
    static int stTree[];

    public static void init(int n) {
        stTree = new int[4 * n];
    }

    public static int buildST(int arr[], int i, int start, int end) {
        if (start == end) {
            stTree[i] = arr[start];
            return arr[start];
        }
        int mid = (start + end) / 2;
        int leftSum = buildST(arr, 2 * i + 1, start, mid);
        int rightSum = buildST(arr, 2 * i + 2, mid + 1, end);
        stTree[i] = leftSum + rightSum;
        return stTree[i];
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8};
        int n = arr.length;
        init(n);
        buildST(arr, 0, 0, n - 1);

        // Print only the relevant part of the segment tree
        for (int i = 0; i < 2 * n - 1; i++) {
            System.out.print(stTree[i] + " ");
        }
    }
}
