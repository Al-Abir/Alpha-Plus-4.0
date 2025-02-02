package DP;

public class KnapsackTabulation {
    
    public static void main(String[] args) {
        int p[] = {0, 1, 2, 5, 6};  // Value array (profit)
        int wt[] = {0, 2, 3, 4, 5}; // Weight array
        int m = 8, n = 4;  // m = Knapsack capacity, n = Number of items
        
        int k[][] = new int[n+1][m+1];

        // **Knapsack DP Table Filling**
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= m; w++) {
                if (i == 0 || w == 0) {
                    k[i][w] = 0;
                } else if (wt[i] <= w) {  // Fix: `wt[i] <= w`
                    k[i][w] = Math.max(p[i] + k[i - 1][w - wt[i]], k[i - 1][w]); // Fix: Add semicolon
                } else {
                    k[i][w] = k[i - 1][w]; 
                }
            }
        }

        // **Finding Selected Items (Backtracking)**
        int i = n;
        int j = m;
        while (i > 0 && j > 0) {
            if (k[i][j] == k[i - 1][j]) {
                System.out.println("Item " + i + ": Not Included (0)");
                i--;
            } else {
                System.out.println("Item " + i + ": Included (1)");
                j = j - wt[i]; // Fix: Subtract `wt[i]`
                i--;
            }
        }

        // **Final Maximum Profit**
        System.out.println("Maximum Profit: " + k[n][m]);
    }
}
