package Tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static class level{
        public static void inorderTraversal(Node root){
            if(root==null){
                return ;
            }
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }


        public static void LevelOrder_Traverse(Node root){
            if(root==null){
                return;
            }
            Queue<Node> q = new LinkedList<>();
            q.add(root);
            q.add(null);

            while(!q.isEmpty()){
                Node courrNode = q.remove();
                if(courrNode==null){
                     System.out.println();

                     if(q.isEmpty()){
                        break;
                    }else{
                        q.add(null);
                    }
                }else{
                    System.out.print(courrNode.data + " ");

                    if(courrNode.left !=null){
                         q.add(courrNode.left);
                    }
                    if(courrNode.right!=null){
                        q.add(courrNode.right);
                    }
                }
                
            }

        }

        // Height of  Tree

        public static int height(Node root){
            if(root==null){
                return 0;
            }

            int lh = height(root.left);
            int rh = height(root.right);
            return Math.max(lh,rh) +1;
        }
    
    
    
    }

  
   
    public static void main(String[] args) {
        
        // int nodes[] = {1,2,4,-1,-1,5,-1,-1,3,-1,6-1,-1};

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        level.inorderTraversal(root);
        System.out.println();
        level.LevelOrder_Traverse(root);

        System.out.println(level.height(root));



    }
}
