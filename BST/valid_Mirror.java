package BST;

import java.util.ArrayList;

public class valid_Mirror {
    public static class Node{
        int data ;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            this.left = null;
            this.right= null;
        }
    }
    
    public static Node BST(Node root, int val){
         if(root==null){
            root = new Node(val);
            return root;
         }
         if(root.data>val){
            root.left = BST(root.left, val);
         }else{
            root.right = BST(root.right, val);
         }
       return root;

    }
    public static void Preorder(Node root){
        if(root==null){
            return;
        }

        //Root -> left -> right;
        Preorder(root.left);
        System.out.print(root.data + " ");
        Preorder(root.right);
    }

    public static void leaf_Path(Node root , ArrayList<Integer> a){
        if(root==null){
            return;
        } 
        a.add(root.data);
     
        if(root.left ==null && root.right==null){
            Print_Path(a);
        }
        leaf_Path(root.left, a);
        leaf_Path(root.right, a);
        a.remove(a.size()-1); // this is called backtrack
     
    }

    public static void Print_Path(ArrayList<Integer> a){
        for(int i =0; i<a.size(); i++){
            System.out.print(a.get(i) + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        
      int values[] ={8,5,3,6,10,11,14};
      Node root = null;
      for(int i =0; i<values.length; i++){
         root = BST(root, values[i]);
      }

      Preorder(root);
      System.out.println();
      leaf_Path(root, new ArrayList<>());
    }
}
