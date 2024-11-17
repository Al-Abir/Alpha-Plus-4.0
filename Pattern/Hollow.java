package Pattern;

public class Hollow {
   public static void hollow_rectangle(int totRow, int totClos){
               for(int i =1; i<=totRow; i++){
                for(int j =1; j<=totClos; j++){

                    if(i ==1 || i == totRow  || j==1 || j==totClos){
                        System.err.print("*");
                    }else{
                          System.out.print(" ");
                    }
                }
                System.err.println();
               }
   }
    public static void main(String[] args) {
        hollow_rectangle(4, 5);
    }
}
