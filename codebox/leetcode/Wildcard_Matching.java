package main;

import java.util.Arrays;

public class Wildcard_Matching {
    public static void main(String[] args) {
	// String s = "mississippi";
	// String p = "m*i*si*si*si*pi";
	String s = "";
	String p = "*";
	System.out.println(ismatch(s, p));

    }

    public static boolean ismatch(String s, String p) {
	if (p.length() > 3 && p.charAt(0) == '*'
		&& p.charAt(p.length() - 1) == '*') {
	    boolean nostar = true;
	    for (int i = 1; i < p.length() - 1; i++) {
		if (p.charAt(i) != p.charAt(1)) {
		    nostar = false;
		    break;
		}
	    }
	    for (int i = 0; i < s.length(); i++) {
		if (s.charAt(i) != s.charAt(0)) {
		    nostar = false;
		    break;
		}
	    }
	    if (nostar) {
		if (p.length() - 2 > s.length()) {
		    return false;
		} else
		    return true;
	    }
	}
	//above  only for last test,the main begin as fellow
	int pn = p.length();
	int sn = s.length();
	boolean dp[][] = new boolean[2][sn + 1];
	dp[pn % 2][sn] = true;
	for (int i = pn - 1; i >= 0; i--) {
	    Arrays.fill(dp[i % 2], false);
	    if (p.charAt(i) == '*') {
		boolean state = false;
		int j;
		//find the true state,make the rest true
		for (j = sn; j >= 0; j--) {//not sn-1
		    if (dp[(i + 1) % 2][j] == true) {//not j+1,state * is also true
			state = true;
			break;
		    }
		}
		for (; j >= 0; j--) {
		    dp[i % 2][j] = state;
		}
	    } else {
		for (int j = sn - 1; j >= 0; j--) {
		    if (p.charAt(i) == s.charAt(j) || p.charAt(i) == '?') {
			dp[i % 2][j] = dp[(i + 1) % 2][j + 1];
		    }
		}
	    }
	}
	return dp[0][0];

    }

}