package BST;

public class Search {

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

    public static boolean Search(Node root,int key){
        if(root==null){
            return false;
        }

        if(root.data==key){
            return true;
        }
        if(root.data>key){
            return Search(root.left, key);
        }else{
            return Search(root.right, key);
        }
    }

    public static void main(String[] args) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = Build_BST(root, values[i]);
        }

        Inorder(root);
         System.out.println();
        if(Search(root, 6)){
            System.out.println("Key Found");
        }else{
            System.out.println("Key Not Found");
        }
  
    }
}
