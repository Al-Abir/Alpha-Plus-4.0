package Recursion;

public class Chess {

    public static boolean isSafe(char board [][], int row , int col){
         // up 
         for(int i = row-1; i>=0; i--){  
             if(board[i][col]=='Q'){
                return false;
             }
         }

         //left diagonal
         for(int i = row-1,  j=col-1;  i>=0 && j>=0; i--,j--){
            if(board[i][j]=='Q'){
                return false;
             }
         }

         //right diagonal
         for(int i=row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]=='Q'){
                return false;
             }
         }
         return true;
    }
    public static void chessBoard(char board[][], int row) {
        // base case
        if (row == board.length) {
            printBoard(board); // Corrected spelling of "printBoard"
            return;
        }

        for (int col = 0; col < board.length; col++) {
          if (isSafe(board ,row, col)){
                board[row][col] = 'Q'; // Place a queen
                chessBoard(board, row + 1); // Recur to the next row
                board[row][col] = '.'; // Backtrack
            }
   
        }
    }

    public static void printBoard(char board[][]) { // Corrected method definition
        System.out.println("----------Chess Board --------");
        for (int i = 0; i < board.length; i++) {
           
            for (int j = 0; j < board[i].length; j++) { // Changed to board[i].length for clarity
                System.out.print(board[i][j] + " ");
            }
            System.out.println(); // Changed from System.err to System.out
        }
        System.out.println(); // Added extra line for better readability
    }

    public static void main(String[] args) {
        int n = 4;
        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.'; // Initialize the board with empty cells
            }
        }
        chessBoard(board, 0);
    }
}
