package Stack;

import java.util.Stack;

public class NextGreater {
    public static void main(String[] args) {
        int arr[] = {6, 8, 0, 1, 3};

        int NextArray[] = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i = arr.length-1; i>=0; i--){
             
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
              NextArray[i]=-1;
            }else{
                NextArray[i]= arr[st.peek()];
            }

            st.push(i);

        }

        // Initialize all elements of NextArray to -1
        /*for (int i = 0; i < arr.length; i++) {
            NextArray[i] = -1;
         }

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    NextArray[i] = arr[j];
                    break;
                }
            }
          }
            */

        // Print the NextArray
        for (int i = 0; i < NextArray.length; i++) {
            System.out.print(NextArray[i] + " ");
        }
    }
}
