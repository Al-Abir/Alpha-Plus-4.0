package DP;

public class knapsack_recursion {
    public static int knapsack(int val[] , int wt[], int w , int n){
        if(n==0 || w==0){
            return 0;
        }
        if(wt[n-1]<=w){
            int ans = val[n-1] + knapsack(val, wt, w-wt[n-1], n-1);
            int ans2 = knapsack(val, wt, w, n-1);
            return Math.max(ans, ans2);
        }else{
           return knapsack(val, wt, w, n-1);
        }
    }
    public static void main(String[] args) {
        int val[] = {15,14,10,45,30};
        int wt[]={2,5,1,3,4};
        int w=7;
        int n =val.length;
        int ans = knapsack(val, wt, w,n);
        System.out.println(ans);
    }
}
