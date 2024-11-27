package Array;

public class Linear_Search {

    public static int lineaSearch(int arr[], int k){

        for(int i =0; i<arr.length ; i++){
            if(k == arr[i]){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr [] = {10,30,34,35,68};
        int key = 10;

       int ans = lineaSearch(arr, key);

       if(ans==-1){
         System.out.println("Key is not Found");
       }else{
        System.out.println("Key is Found");
       }
    }
}
