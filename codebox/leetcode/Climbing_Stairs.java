package main2;

public class Climbing_Stairs {

    public int climbStairs(int n) {
        // Start typing your Java solution below
        // DO NOT write main() function
       int dp[]=new int[Math.max(n, 2)];
       dp[0]=1;
       dp[1]=2;
       for(int i=2;i<n;i++){
	   dp[i]=dp[i-1]+dp[i-2];
       }
       return dp[n-1];
    }

}
