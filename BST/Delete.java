package BST;

public class Delete {

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
    public static Node Delete(Node root, int data){
        if (root ==null){
            return root;
        }

        if(root.data>data){
            root.left = Delete(root.left, data);
        }
        else if(root.data<data){
            root.right = Delete(root.right, data);
        }else{
            // this main part handle 3 logic
            if(root.left ==null && root.right==null){
                return null;
            }

            // 2nd case
            if(root.left == null){
                return root.right;
            }
            if(root.right==null){
                return root.left;
            }

            // 3rd casse find scecessor

            Node secessor = Findsecessor(root.right);
            root.data = secessor.data;
            root.right =Delete(root.left, secessor.data);

        }
        return root;
    }
    public static Node Findsecessor(Node root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
    public static void main(String[] args) {
        int values[] = { 8,5,3,1, 4, 6, 10,11,14};
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = Build_BST(root, values[i]);
        }

        Inorder(root);
         System.out.println();
        // if(Search(root, 6)){
        //     System.out.println("Key Found");
        // }else{
        //     System.out.println("Key Not Found");
        // }
        root = Delete(root,1);
        System.out.println();
        Inorder(root);
    }
    
}
