package HashMap;

import java.util.HashMap;

public class Largest_sum {
    public static int maxLen(int arr[]){
        int len =0;
        for(int i =0; i<arr.length; i++){
            int sum =0;
            for(int j=i; j<arr.length; j++){
                sum+=arr[j];
                if(sum==0){
                    len = Math.max(len, j-i+1);
                }
            }

        }
        return len;
    }
    public static void main(String[] args) {
        int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
        System.out.println(maxLen(arr));  //0(n^2)

        // hashamp
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0;
        int len =0;
        for(int i=0;i<arr.length; i++){
            sum+=arr[i];
            if(map.containsKey(sum)){
              len = Math.max(len, i- map.get(sum));
            }else{
                map.put(sum, i);
            }
        }
        System.out.println("largest Length " + len);
    }
}
