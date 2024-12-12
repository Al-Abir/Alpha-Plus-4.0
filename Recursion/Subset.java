package Recursion;
import java.util.*;
public class Subset {
    public static void Findsubset(String str, String ans,int i){
        //base case
        if(i== str.length()){
            System.out.println(ans);
            return;
        }
        //recursion call

        Findsubset(str, ans+str.charAt(i), i+1);
        Findsubset(str, ans, i+1);
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String  str ;
       str = sc.nextLine();
       
       Findsubset(str, " ",0);

    }
}
