package Stack;

import java.util.Stack;

public class Reverse_Stack {
    public static void pushAtBottom(Stack<Integer> st , int data){
     
        if(st.isEmpty()){
            st.push(data);
            return;
        }

        int top = st.pop();
        pushAtBottom(st, data);
        st.push(top);


    }

    public static void reverse(Stack<Integer> st){
        if(st.isEmpty()) {
            return;
        }
        int top = st.pop();
        reverse(st);
        pushAtBottom(st,top);

    }
    public static void printStack(Stack<Integer> st) {
        while (!st.isEmpty()) {
           System.out.println(st.pop());
        }

    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);

       
        printStack(st);
        reverse(st);
        System.out.println();
        printStack(st);

    }
}
