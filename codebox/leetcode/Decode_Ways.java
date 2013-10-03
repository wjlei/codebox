package main;

public class Decode_Ways {
	public static int numDecodings(String s) {
		// Start typing your Java solution below
		// DO NOT write main() function
		if (s.length() <= 0)
			return 0;

		char num[] = s.toCharArray();
		int dp[] = new int[num.length + 1];
		dp[0] = 1;
		for (int i = 0; i < num.length; i++) {
			if (num[i] != '0')
				dp[i + 1] += dp[i];
			if (i >= 1) {
				int v = (int) (num[i - 1] - '0');
				v *= 10;
				v += (int) (num[i] - '0');
				if (v > 9 && v <= 26)// two digit
					dp[i + 1] += dp[i - 1];
			}
		}
		return dp[s.length()];
	}

	public static void main(String args[]) {
		System.out.print(numDecodings("101"));

	}
}
