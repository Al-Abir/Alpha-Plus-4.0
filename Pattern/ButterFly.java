package Pattern;

public class ButterFly {
    public static void ButterFly_Pattern(int n){
        for(int i =1; i<=n; i++){
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            for(int j =1; j<= 2 *(n-i); j++){
                System.out.print(" ");
            }

            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }


        for(int i =n; i>=1; i--){
            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            for(int j =1; j<= 2 *(n-i); j++){
                System.out.print(" ");
            }

            for(int j =1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        ButterFly_Pattern(4);
    }
}
