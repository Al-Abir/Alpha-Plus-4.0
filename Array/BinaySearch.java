package Array;
import java.util.*;


public class BinaySearch {
    public static int binarySearch(int num[], int key){

        int start = 0;
        int end = num.length-1;
        
        while(start<=end){

            int mid = (start+end)/2;

            if(num[mid]==key){
                return mid;

            }else if( num[mid]<key){
                 start = mid +1  ;     
            }else if(num[mid]>key){
                end = mid -1;

            }
        }
        return -1;
        
    }
    public static void main(String[] args) {
        // must be sorted Array 
        int num [] = {10,20,30,56,70}; 
        int key = 56;

       int ans  = binarySearch(num, key);

       if(ans == -1){
         System.out.println("Key is Not Found");
       }else{
        System.out.println("Key is Found");
       }
    }
}
