
package Array;
import java.util.*;

public class LargestArray {
    public static int  LargestNumber(int num[]){
          int Largest = Integer.MIN_VALUE;

          for(int i  =1; i<num.length; i++){

               if(Largest<num[i]){
                Largest = num[i];
               }
          }
          return Largest;
    }
    public static void main(String[] args) {
          int num [] = {10,20,30,56,22};

         System.out.println("Largest Number In Array " + LargestNumber(num)); 
    }
}


