package Stack;

import java.util.*;
public class Push_Bottom {

    public static void pushAtBottom(Stack<Integer> s , int data){
        //base case
       if(s.isEmpty()){
        s.push(data);
        return;
       }

        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String[] args){

       Stack<Integer> s = new Stack<>();
       s.add(1);
       s.add(2);
       s.add(3);

       pushAtBottom(s, 4);

       while (!s.isEmpty()) {
        System.out.println(s.peek());
        s.pop();
        
       }

    }
}
