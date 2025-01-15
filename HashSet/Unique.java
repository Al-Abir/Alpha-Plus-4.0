package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Unique {


    public static int countDistinct(int[] arr) {


        int count = 0;
        
        // Loop through the array to check each element
        for (int i = 0; i < arr.length; i++) {
            boolean isDistinct = true;
            
            // Compare with all the previous elements
            for (int j = 0; j < i; j++) {
                if (arr[i] == arr[j]) {
                    isDistinct = false;
                    break;
                }
            }
            
            // If the element is distinct, increment the count
            if (isDistinct) {
                count++;
            }
        }
        
         return count;
    }
    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4, 32, 1, 3, 4, 3};
        System.out.println("Number of distinct elements: " + countDistinct(arr));

        Set<Integer> set = new HashSet<>();
        for(int i =0; i<arr.length; i++){
            set.add(arr[i]);
        }


        System.out.println(set.size());

    }
}
