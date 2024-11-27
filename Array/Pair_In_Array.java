package Array;

public class Pair_In_Array {
    public static void Pair_array(int num[]){
       for(int i =0; i<num.length; i++){
        for(int j=i+1; j<num.length;j++){
            System.out.print("(" + num[i] + "," + num[j]+ ")");
        }
        System.err.println();
       }
    }
   public static void main(String[] args) {

     int number[] = {2,4,6,8,10};
      Pair_array(number);
   }
}
