package Stack;
import java.util.Stack;

public class Duplicate {

    public static boolean duplicate_braket(String str){
            

        Stack<Character> st = new Stack<>();

        for(int i=0; i<str.length(); i++){
            char ch =  str.charAt(i);
            
            if(ch==')' || ch=='}'|| ch==']'){
                int count =0;
                while((ch==')' && st.peek() !='(') || (ch=='}' && st.peek() !='{') || (ch==']' && st.peek() !='[')){
                    st.pop();
                    count++;
                }
                if(count<1){
                    return true;
                }


            }else{
                st.push(ch);
            }
        }



    return false;
    }
    public static void main(String[] args) {
        String str = "((a+b))";

        System.out.println(duplicate_braket(str));
    }
}
