package Tree;

public class CountofNode {

    public  static class Node{
        int data;
        Node left;
        Node right;


        Node(int data){
            this.data = data;
            this.left =  null;
            this.right = null;

        }
    }

   public static class InnerCountofNode {
          
        public static int Count_node(Node root){
             if(root==null){
                return 0;
             }

             int leftNode =Count_node(root.left);
             int rightNode = Count_node(root.right);

             return leftNode+rightNode+1;

        }

        public static int Sum_Node_value(Node root){
            if(root==null){
                return 0;
            }
            int leftSum = Sum_Node_value(root.left);
            int rightSum = Sum_Node_value(root.right);

            return leftSum+ rightSum + root.data;
        }
    
     }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);

        System.out.println(InnerCountofNode.Count_node(root));


        System.out.println(InnerCountofNode.Sum_Node_value(root));

    }
}
