package Tree;

public class BuildTree {
    static class Node{
        int data ;
        Node left;
        Node right;
      
        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class BinaryTree {
        static int idx =-1;
        public static Node buildTeeNode(int nodes[]){
            idx++;
            if(nodes[idx]==-1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTeeNode(nodes);
            newNode.right = buildTeeNode(nodes);

          return newNode;
        }
        // pre-order
        public static void Preorder(Node root){

            // 
            if(root==null){
                return ;
            }

            System.out.print(root.data + " ");
            Preorder(root.left);
            Preorder(root.right);
        }

        //In order 

        public static void InOrder(Node root){
            // base case
            if(root==null){
                return;
            }
            InOrder(root.left);
            System.out.print(root.data + " ");
            InOrder(root.right);
        }

        public static void PostOrder(Node root){
            // base case 
            if(root== null){
                return;
            }

            PostOrder(root.left);
            PostOrder(root.right);
            System.out.print(root.data + " ");
        }
    
    }
    public static void main(String[] args) {
        int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
        // BinaryTree tree = new BinaryTree();
        
        Node root =  BinaryTree.buildTeeNode(nodes);
        System.out.println(root.data);

        BinaryTree.Preorder(root);
        System.out.println();
        BinaryTree.InOrder(root);
        System.out.println();
        BinaryTree.PostOrder(root);

    }
}
