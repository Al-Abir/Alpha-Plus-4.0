package Stack;

import java.util.Stack;

public class Valid {

    public static boolean valid_bracket(String str) {

        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else {
                if (st.isEmpty()) {
                    return false; // Unmatched closing bracket
                }
                if ((ch == ')' && st.peek() == '(') || 
                    (ch == '}' && st.peek() == '{') || 
                    (ch == ']' && st.peek() == '[')) {
                    st.pop();
                } else {
                    return false; // Mismatched bracket
                }
            }
        }

        return st.isEmpty(); // Return true if stack is empty (all brackets matched)
    }

    public static void main(String[] args) {
        String str = "(])";

        System.out.println(valid_bracket(str)); // Should print false
    }
}
