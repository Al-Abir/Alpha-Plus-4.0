package Stack;

import java.util.Stack;

public class Histogram {

    public static int max_area(int height[]) {
        Stack<Integer> st = new Stack<>();
        int nsl[] = new int[height.length]; // Nearest Smaller to Left
        int nsr[] = new int[height.length]; // Nearest Smaller to Right
        int maxArea = 0;

        // Calculate Nearest Smaller to Right (NSR)
        for (int i = height.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsr[i] = height.length;
            } else {
                nsr[i] = st.peek();
            }
            st.push(i);
        }

        // Clear the stack before calculating NSL
        st.clear();

        // Calculate Nearest Smaller to Left (NSL)
        for (int i = 0; i < height.length; i++) {
            while (!st.isEmpty() && height[st.peek()] >= height[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                nsl[i] = -1;
            } else {
                nsl[i] = st.peek();
            }
            st.push(i);
        }

        // Calculate the maximum area
        for (int i = 0; i < height.length; i++) {
            int h = height[i];
            int width = nsr[i] - nsl[i] - 1; // Width between NSL and NSR
            int area = h * width;           // Area = height * width
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int height[] = {2, 1, 5, 6, 2, 3};
        System.out.println(max_area(height)); // Should output 10
    }
}
