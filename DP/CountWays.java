package DP;

import java.util.Arrays;
import java.util.Scanner;

public class CountWays {
    public static int memoization(int n, int ways[]){
        if(n==0){
            return 1;
        }
        if(n==-1){
            return 0;
        }
        return memoization(n-1, ways) + memoization(n-2, ways);
    }
    public static int tabulation(int n){
        int dp[] = new int[n+1];
        dp[0]=1;
        for(int i=1; i<=n; i++){
           if(i==1){
             dp[i]= dp[i-1] +0;
           }else{
            dp[i]= dp[i-1] +dp[i-2];

           }
        }
        return dp[n];
    }
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int ways[] = new int[n+1];

         Arrays.fill(ways,-1);
       System.out.println(memoization(n,ways));
       System.out.println(tabulation(n));
    }
}
