package BST;

import java.util.ArrayList;

public class ValidMirror {

    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Method to insert a value into the BST
    public static Node BST(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = BST(root.left, val);
        } else {
            root.right = BST(root.right, val);
        }
        return root;
    }

    // Inorder traversal (Left -> Root -> Right)
    public static void Inorder(Node root) {
        if (root == null) {
            return;
        }
        Inorder(root.left);
        System.out.print(root.data + " ");
        Inorder(root.right);
    }

    // Preorder traversal (Root -> Left -> Right)
    public static void Preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        Preorder(root.left);
        Preorder(root.right);
    }

    // Method to print all root-to-leaf paths
    public static void leaf_Path(Node root, ArrayList<Integer> a) {
        if (root == null) {
            return;
        }
        a.add(root.data); // Add current node to the path

        // If leaf node, print the path
        if (root.left == null && root.right == null) {
            Print_Path(a);
        }

        // Recur for left and right subtrees
        leaf_Path(root.left, a);
        leaf_Path(root.right, a);

        // Backtrack: Remove the current node
        a.remove(a.size() - 1);
    }

    // Helper method to print a path
    public static void Print_Path(ArrayList<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }

    // Method to check if the tree is a valid BST
    public static boolean isValid(Node root, Node min, Node max) {
        if (root == null) {
            return true; // Base case
        }

        if (min != null && root.data <= min.data) {
            return false;
        }

        if (max != null && root.data >= max.data) {
            return false;
        }

        // Check validity for left and right subtrees
        return isValid(root.left, min, root) && isValid(root.right, root, max);
    }

    // Method to create a mirror of the tree
    public static Node Mirror(Node root) {
        if (root == null) {
            return null;
        }

        // Recursively mirror left and right subtrees
        Node leftSubtree = Mirror(root.left);
        Node rightSubtree = Mirror(root.right);

        // Swap left and right
        root.left = rightSubtree;
        root.right = leftSubtree;

        return root;
    }

    // Main method
    public static void main(String[] args) {
        int values[] = {8, 5, 3, 6, 10, 11, 14};
        Node root = null;

        // Build the BST
        for (int i = 0; i < values.length; i++) {
            root = BST(root, values[i]);
        }

        // Perform Inorder traversal
        System.out.print("Inorder Traversal: ");
        Inorder(root);
        System.out.println();

        // Print all paths from root to leaf
        System.out.println("Leaf to root paths:");
        leaf_Path(root, new ArrayList<>());

        // Check if the tree is a valid BST
        if (isValid(root, null, null)) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }

        // Create and print the mirror of the tree
        root = Mirror(root);
        System.out.print("Preorder Traversal of Mirrored Tree: ");
        Preorder(root);
        System.out.println();
    }
}
