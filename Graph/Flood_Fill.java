package Graph;

import java.util.Arrays;

public class Flood_Fill {

    public static void helper(int[][] image, int oldColor, int newColor, int rows, int col, int i, int j) {
        // Base case: Out of bounds or pixel does not match the oldColor or already updated
        if (i < 0 || i >= rows || j < 0 || j >= col || image[i][j] != oldColor) {
            return;
        }

        // Update the pixel color to the newColor
        image[i][j] = newColor;

        // Recur in all four directions
        helper(image, oldColor, newColor, rows, col, i + 1, j);
        helper(image, oldColor, newColor, rows, col, i - 1, j);
        helper(image, oldColor, newColor, rows, col, i, j + 1);
        helper(image, oldColor, newColor, rows, col, i, j - 1);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int col = image[0].length;
        int oldColor = image[sr][sc];

        // Avoid infinite recursion if the oldColor is the same as the newColor
        if (oldColor != newColor) {
            helper(image, oldColor, newColor, rows, col, sr, sc);
        }

        return image;
    }

    public static void main(String[] args) {
        // Create an instance of the Flood_Fill class
        Flood_Fill solution = new Flood_Fill();

        // Example test case
        int[][] image = {
            {1, 1, 1},
            {1, 1, 0},
            {1, 0, 1}
        };
        int sr = 1; // Starting row
        int sc = 1; // Starting column
        int newColor = 2;

        // Print the original image
        System.out.println("Original Image:");
        for (int[] row : image) {
            System.out.println(Arrays.toString(row));
        }

        // Perform flood fill
        int[][] updatedImage = solution.floodFill(image, sr, sc, newColor);

        // Print the updated image
        System.out.println("Updated Image:");
        for (int[] row : updatedImage) {
            System.out.println(Arrays.toString(row));
        }
    }
}
