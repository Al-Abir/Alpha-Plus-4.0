package HashMap;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {

    public static int feq(int arr[]) {
        // Create a HashMap to store the frequency of each element
        Map<Integer, Integer> freq = new HashMap<>();
        int len = arr.length;

        // Populate the frequency map
        for (int n : arr) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Check for the majority element
        for (Map.Entry<Integer, Integer> m : freq.entrySet()) {
            if (m.getValue() > len / 2) {
                return m.getKey(); // Return the majority element
            }
        }

        // Return -1 if no majority element is found
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {3, 2, 3};

        // Call the feq method and store the result
        int result = feq(arr);

        // Print the result
        if (result != -1) {
            System.out.println("Majority Element: " + result);
        } else {
            System.out.println("No Majority Element Found");
        }
    }
}
