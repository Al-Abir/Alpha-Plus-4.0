package HashSet;

import java.util.HashSet;
import java.util.Set;

public class Union_Intersection {
    public static void main(String[]args){
      
        int arr1[]= {7,3,9};
        int arr2[]= {6,3,9,2,9,4};

        Set<Integer> set = new HashSet<>();

        for(int i : arr1){
            set.add(i);
        }
        for(int i=0; i<arr2.length; i++){
            set.add(arr2[i]);
        }
        System.out.println(set.size());
        for(Integer i : set){
            System.out.print(i + " ");
        }
       set.clear();
       System.out.println();

       for(int i : arr1){
        set.add(i);
      }
      int count =0;
      for(int i=0; i<arr2.length; i++){
           if(set.contains(arr2[i])){
            
            count++;
            //values print
            System.out.print(arr2[i] + " ");
            set.remove(arr2[i]);
            
           }
      }
      System.out.println();

      System.out.println(count);

  
    }

}
