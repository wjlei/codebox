package main;

import java.util.Arrays;

public class Find_qualified_integer {
	// find min m,make n*m only contain 0,1
	// N=99,M=1122334455667789
	// N*m=111111111111111111
	static long find(int n) {
		if(n==1)
			return 1;
		long dp[][] = new long[2][n];
		long count = 1;
		Arrays.fill(dp[0], Long.MAX_VALUE);
		dp[0][0] = 0;
		long ans;
		for (int i = 1;; i++) {
			Arrays.fill(dp[i % 2], Long.MAX_VALUE);
			int start = (int)(count % n);
			dp[i % 2][start] = Math.min(dp[(i - 1) % 2][start], count);
			for (int j = 0; j < n; j++) {
				if (dp[(i - 1) % 2][j] != Long.MAX_VALUE) {
					dp[i % 2][(start + j) % n] = Math.min(count + dp[(i - 1) % 2][j],
							dp[(i - 1) % 2][(start + j)% n]);
				}
			}
			count *= 10;
			if (dp[i%2][0] != Long.MAX_VALUE) {
				ans = dp[i%2][0];
				break;
			}
		}
		return ans / n;

	}

	public static void main(String args[]) {
		System.out.println(find(99));
	}

}
