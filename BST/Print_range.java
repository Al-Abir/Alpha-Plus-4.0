package BST;

public class Print_range {
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

        public static Node Build_BST(Node root, int val) {
            if (root == null) {
                root = new Node(val);
                return root;
            }

            if (root.data > val) {
                root.left = Build_BST(root.left, val);
            } else if (root.data < val) {
                root.right = Build_BST(root.right, val);
            }

            return root;
        }

        public static void Inorder(Node root){
            if(root==null){
                return ;
            }

            Inorder(root.left);
            System.out.print(root.data + " ");
            Inorder(root.right);
        }

   
    public static void Print_range1(Node root, int k1, int k2){
        if (root == null) {
            return;
        }
   
        if (root.data > k1) {
            Print_range1(root.left, k1, k2);
        }
    
        // Print the current node if it's within the range
        if (root.data >= k1 && root.data <= k2) {
            System.out.print(root.data + " ");
        }
    
        // Recur for right subtree if there is a possibility of values in range
        if (root.data < k2) {
            Print_range1(root.right, k1, k2);
        }
    }
    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 ,10,11, 14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = Build_BST(root, values[i]);
        }

        Inorder(root);
         System.out.println();
 
        Print_range1(root,5,12);
  
    }
}
