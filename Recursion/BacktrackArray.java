package Recursion;

public class BacktrackArray {
    public static void changeArray(int arr[], int i, int val){
        //base case
          if(i==arr.length){
            printArray(arr);
            return;
          }

        //work
        arr[i] =val;
        changeArray(arr, i+1, val+1);
        arr[i] = arr[i]-2;
      
    }
    public static void printArray(int arr[]){
        for(int i =0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = new int[5];
        changeArray(arr, 0, 1);   
        printArray(arr);
    }
}
