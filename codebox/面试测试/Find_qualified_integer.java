package main;

import java.util.Arrays;

public class Find_qualified_integer {
    // find min m,make n*m only contain 0,1
    // N=99,M=1122334455667789
    // N*m=111111111111111111
    static int find(int n) {
	int dp[][] = new int[100][n];
	int count = 1;
	Arrays.fill(dp[0], Integer.MAX_VALUE);
	dp[0][0] = 0;
	int ans;
	for (int i = 1;; i++) {
	    Arrays.fill(dp[i], Integer.MAX_VALUE);
	    int start=count%n;
	    dp[i][start]=Math.min(dp[(i-1)][start],count);
	    for (int j = 0; j < n; j++) {
		if(dp[(i-1)][j]!=Integer.MAX_VALUE){
		    dp[i][(start+j)%n]=Math.min(count+dp[(i-1)][j],dp[(i-1)][(start+j)%n]);
		}
	    }
	    count *= 10;
	    if(dp[i][0]!=Integer.MAX_VALUE){
		ans=dp[i][0];
		break;
	    }
	}
	for(int i=0;i<10;i++){
	    for(int j=0;j<n;j++){
		System.out.print(dp[i][j]+" ");
	    }
	    System.out.println();
	}
	return ans/n;
	

    }
  public   static void main(String args[]){
	System.out.println(find(4));
    }

}
